$(document).ready(function() {

    $("#main_picture").change(function(event) {
        // Stop default form Submit.
        event.preventDefault();
        // Call Ajax Submit.
        ajaxSubmitForm();
    });
});

function ajaxSubmitForm() {
    // Get form
    var form = $('#create_article')[0];
    var data2 = new FormData(form);

    // $("#submitButton").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "UploadServlet",
        data: data2,
        // prevent jQuery from automatically transforming the data into a query string
        processData: false,
        contentType: false,
        cache: false,
        timeout: 1000000,
        success: function(data, textStatus, jqXHR) {
            alert("Image upload ;)");
            // $('#mainPicture').html(data);
            $('#mainPicture').val(data);
            console.log("SUCCESS : ", data);
            // $("#submit").prop("disabled", false);
            // $('#create_article')[0].reset();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert("Image upload not success! = ");
            $("#mainPicture").html(jqXHR.responseText);
            console.log("ERROR : ", jqXHR.responseText);
            // $("#submit").prop("disabled", false);
        }
    });

}