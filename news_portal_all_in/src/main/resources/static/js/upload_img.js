$(document).ready(function() {
/**
     * Settings for summernote editor.
     */
    window.onload = function () {
        $('#text').summernote({
            lang: 'ru-RU',
            height: 500,
            minHeight: 500,
            placeholder: 'Please enter the contents of the notification.',
            // dialogsFade: true,// Add fade effect on dialogs
            dialogsInBody: true,// Dialogs can be placed in body, not in
            disableDragAndDrop: false,// default false You can disable drag and drop
            focus: true,                  // set focus to editable area after initializing summe
            toolbar: [
                ['style', ['style','bold','italic','underline','clear']],
                ['font', ['strikethrough','superscript','subscript']],
                ['fontsize', ['fontsize']],
                ['fontname', ['fontname']],
                ['height', ['height']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['table', ['table']],
                ['insert', ['link', 'picture', 'uploadfile', 'video']],
                ['view', ['fullscreen', 'codeview', 'help']]
                // ,

            ],
            callbacks: { // callback
                // Callback function for uploading pictures
                onImageUpload: function (files, editor, $editable) {
                    editor = $(this);
                    console.log(files)
                    uploadFile(files[0], editor, $editable);
                }
            }
        });

        function uploadFile(files, editor, editable) {
            data = new FormData();
            data.append("files", files);
            $.ajax({
                data: data,
                method: "POST",
                url: "UploadServlet",
                headers: {'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')},
                cache: false,
                contentType: false,
                processData: false,
                timeout: 1000000,
                success: function (src) {
                    // $('#text').summernote('insertText', src);
                    // $('#text').summernote('insertImage', src);
                    var html = $('#text').summernote('code');
                    var url = "";
                    // setting updated html with image url
                    $('#text').summernote('code', html + '<img src="' + url + src + '"/>');
                    alert("Image upload!");
                },
                error:
                    function () {
                        alert(JSON.stringify("Upload image failed!"));
                    }
            });
            // .done(
            //     function(json1) {
            //     var src = json1;
            //     alert(JSON.stringify("Well Done!"))
            //
            //
            // })
            // .fail(function( xhr, status, errorThrown ) {
            //     alert( "Sorry, there was a problem!" );
            //     console.log( "Error: " + errorThrown );
            //     console.log( "Status: " + status );
            //     console.dir( xhr );
            // })
        }
    };
});