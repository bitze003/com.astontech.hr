<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<script>

    $(document).ready(function () {
        //attach an onclick function to the remove buttons
        $('.remove_button').click(function(){
            //log name button, and contents of associated text box
            console.log(this.name);
            console.log($('#'+this.name).val());
            //clear the value / contents of the text box
            $('#'+ this.name).val('');
            // submit the form
            $('#vehicle').submit();

        });
    });

</script>

<div class-="wraper">

    <%--    SIDEBAR HERE--%>
    <%@ include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10>
        <div class="col-sm-8">

    <c:set var="idx" value="0" scope="page"/>
    <form:form class="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
        <form:hidden path="id"/>
        <form:hidden path="version"/>
        <br><br><br><br><br>
        <div class="row">
            <div class="form-group">
                <label for="editVehicle" class="col-sm-2 control-label"> Vehicle Color</label>
                <div class="col-sm-8">
                    <form:input path="color" type="text" id="editVehicle" cssClass="form-control"></form:input>
                </div>
            </div>
            <div class="form-group">
                <label for="editVehicle" class="col-sm-2 control-label"> Vehicle License Plate</label>
                <div class="col-sm-8">
                    <form:input path="licensePlate" type="text" id="editVehicle" cssClass="form-control"></form:input>
                </div>
            </div>
            <div class="form-group">
                <label for="editVehicle" class="col-sm-2 control-label"> Vehicle VIN</label>
                <div class="col-sm-8">
                    <form:input path="vIN" type="text" id="editVehicle" cssClass="form-control"></form:input>
                </div>
            </div>
            <div class="form-group">
                <label for="editVehicle" class="col-sm-2 control-label"> Vehicle Year</label>
                <div class="col-sm-8">
                    <form:input path="year" type="text" id="editVehicle" cssClass="form-control"></form:input>
                </div>
            </div>
            <div class="form-group">
                <label for="editVehicle" class="col-sm-2 control-label"> Vehicle Model</label>
                <div class="col-sm-8">
                    <form:input path="vehicleModel.vehicleModelName" type="text" id="editVehicle" cssClass="form-control"></form:input>
                </div>
            </div>
            <div class="form-group">
                <label for="editVehicle" class="col-sm-2 control-label"> Vehicle Make</label>
                <div class="col-sm-8">
                    <form:input path="vehicleModel.vehicleMake.vehicleMakeName" type="text" id="editVehicle" cssClass="form-control"></form:input>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-10>">
                <hr>
            </div>
        </div>
        <div class="col-sm-3">
            <button class="btn btn-primary">Update</button>
        </div>
    </form:form>
</div>
<div class="col-sm-4">

    <%-- SUCCESS Alerts--%>
    <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
        <div class="alert alert-dismissible alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</but`ton>
            <strong>Well done!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
        </div>
    </div>
    <%--  warning Alerts--%>

    <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
        <div class="alert alert-dismissible alert-warning">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Warning!</h4>
            <p>Best check yo self, you're not looking too good. Nulla vitae elit libero, a pharetra augue. Praesent commodo cursus magna, <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
        </div>
    </div>
    <%--  ERROR Alerts--%>
    <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
        </div>

    </div>
</div>
</div>
<%@include file="../../includes/footer.jsp" %>