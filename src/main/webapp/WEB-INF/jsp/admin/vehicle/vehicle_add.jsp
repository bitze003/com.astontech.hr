<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function(){

        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(10000).fadeOut(2000);

    });
</script>

<div class-="wraper">
    <%--    SIDEBAR HERE--%>
    <%@ include file="../vehicle/vehicle_sidebar.jsp" %>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                    <legend>Vehicle Management</legend>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Vehicle Color</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleColor" type="text" class="form-control" id="inputNewVehicle" placeholder="Vehicle Color"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Vehicle LP</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleLicensePlate" type="text" class="form-control" id="inputNewVehicle" placeholder="Vehicle License Plate"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Vehicle VIN</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleVin" type="text" class="form-control" id="inputNewVehicle" placeholder="Vehicle VIN"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNewVehicle" class="col-lg-2 control-label">Vehicle Year</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleYear" type="text" class="form-control" id="inputNewVehicle" placeholder="Vehicle Year"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleModel" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:select  class="form-control" path="newVehicleModel" id="inputNewVehicleModel">
                                <form:options value="0" />
                                <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                    <c:choose>
                                        <c:when test="${vehicleModel.vehicleModelId == vehicleModelId}">
                                            <option  selected value="${vehicleModel.vehicleModelId}"> ${vehicleModel.vehicleModelName} </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${vehicleModel.vehicleModelId}"> ${vehicleModel.vehicleModelName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:select  class="form-control" path="newVehicleMake" id="inputNewVehicleMake">
                                <form:options value="0" />
                                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                    <c:choose>
                                        <c:when test="${vehicleMake.vehicleMakeId == vehicleMakeId}">
                                            <option  selected value="${vehicleMake.vehicleMakeId}"> ${vehicleMake.vehicleMakeName} </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${vehicleMake.vehicleMakeId}"> ${vehicleMake.vehicleMakeName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col0-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Submit</form:button>
                        </div>
                    </div>
                </fieldset>

            </form:form>

        </div>
        <div class="col-sm-4">
            <%--    <div class="col-sm-4">

                <%-- SUCCESS Alerts--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Element added successfully to the database!</strong> You successfully read <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </div>
            <%--  warning Alerts--%>

            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>All fields required.  Please enter an element type and associated element seperated by a new line. <a href="#" class="alert-link">vel scelerisque nisl consectetur et</a>.</p>
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

</div>
<%@include file="../../includes/footer.jsp" %>