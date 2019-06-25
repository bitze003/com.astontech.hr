function buildContactTable() {

    $.getJSON('/api/contact/', {
        ajax: 'true'
    }, function (data) {
        // console.log(data);
        $.each(data, function(index, single) {
            // console.log($('#employee-table'));
            $('#contact-table').find('tbody')
                .append("<tr>" +
                    "<td>" + single.id + "</td>" +
                    "<td>" + single.companyName + "</td>" +
                    "<td>" + single.address.addressNumber + "</td>" +
                    "<td>" + single.address.street + "</td>" +
                    // "<td>" + "<select class='form-control'><option>(Select Project) </option> </select>" + "</td>" +
                    "<td>" + "<button onclick='editContact(" + single.id + ")'>Edit</button>" + "</td>" +
                    "<td>" + "<button data-toggle='modal' data-target='#confirmDeleteModal' data-record-id='" + single.id +"'>Delete</button>" + "</td>" +
                    "</tr>");

        });
    });
}

function deleteModal(){
    $('#confirmDeleteModal').on('click', '.btn-ok', function(e) {
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        console.log("delete");
        $.ajax({
            type: "delete",
            url:"/api/contact/" + id,
            async: true,
            dataType: "json",
            success:function() {
                window.location.reload();
            },
            error: function () {
                alert("Error Deleting Contact!");
            }
        })

    });
    $('#confirmDeleteModal').on('show.bs.modal', function (e) {
        var data = $ (e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });
}

function insertContact(){
    //clear fields in modal
    $('#contactId').val("");
    $('#contactVersion').val("");
    $('#inputContactName').val("");
    $('#inputAddressNumber').val("");
    $('#inputStreet').val("");

    //open modal
    $('#contactModal').modal('show')
}

function saveContact() {
    var id= $('#contactId').val();
    var version= $('#contactVersion').val();
    var companyName = $('#inputContactName').val();
    var addressNumber = $('#inputAddressNumber').val();
    var street = $('#inputStreet').val();

    console.log("save");
    //creating an object in js(json)
    var contact = {
        id: id,
        version: version,
        companyName: companyName,
        addressNumber: addressNumber,
        street: street
    }

    // console.log(employee)

    $.ajax({
        type:"post",
        data: contact,
        url: "/api/contact/",
        async: true,
        dataType: "json",

        success: function () {
            window.location.reload();


        }
    })
}

function editContact(id) {
    //retrieve the employee with the passed in id

    $.getJSON('/api/contact/'+ id, {
        ajax: 'true'
    }, function(contact){
        console.log(contact)

        //populate values (hidden and input)
        $('#contactId').val(contact.id);
        $('#contactVersion').val(contact.version);
        $('#inputContactName').val(contact.companyName);
        $('#inputAddressNumber').val(contact.address.addressNumber);
        $('#inputStreet').val(contact.address.street);

        //open the model
        $('#contactModal').modal('show');
    })
}
