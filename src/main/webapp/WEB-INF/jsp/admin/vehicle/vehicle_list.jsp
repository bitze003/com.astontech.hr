<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp" %>
<%@ include file="../../includes/subnav_admin.jsp" %>

<div class-="wraper">

    <%--    SIDEBAR HERE--%>
    <%@ include file="../vehicle/vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <%--                LIST OF EXISITING ELEMENTS --%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Color</th>
                    <th>LP</th>
                    <th>VIN</th>
                    <th>Year</th>
                    <th>Model</th>
                    <th>Make</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.color}</td>
                        <td>${vehicle.licensePlate}</td>
                        <td>${vehicle.vIN}</td>
                        <td>${vehicle.year}</td>
                        <td>${vehicle.vehicleModel.vehicleModelName}</td>
                        <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                        <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                        <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="../../includes/footer.jsp" %>