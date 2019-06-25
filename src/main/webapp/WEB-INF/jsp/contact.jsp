<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

<c:url value="/static/js/contact.js" var="contact" />
<script src="${contact}"></script>

<script>
    $(document).ready(function() {
        buildContactTable();
        deleteModal();
    })

</script>
<div class="container">

    <h2>Contact Page</h2>
    <button onclick="insertContact()" class="btn btn-default">Add New Contact</button>

    <table id="contact-table" class="table table-striped table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Company Name</th>
            <th>Address Number</th>
            <th>Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <%--jquery will eppend our data here... --%>
        </tbody>
    </table>

    <div id="contactModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Contact Details</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <fieldset>
                            <hidden id="contactId"/>
                            <hidden id="contactVersion"/>

                            <div class="form-group">
                                <label for="inputContactName" class="col-lg-2 control-label">Company Name</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputContactName" placeholder="Company Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputAddressNumber" class="col-lg-2 control-label">Address Number</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputAddressNumber" placeholder="Address Number">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputAddress" class="col-lg-2 control-label">Background</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputAddress" placeholder="Address">
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveContact()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="confirmDeleteModal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Confirm Delete</h4>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete?   This cannont be undone!</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete">Delete</button>
            </div>
        </div>
    </div>
</div>



<%--<p id='employeeList'></p>--%>


<%@include file="includes/footer.jsp" %>