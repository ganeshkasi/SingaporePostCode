<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <script type="application/javascript">
        function retrieveAddressByPostalCode() {
            document.addEventListener('keyup', logKey);

            function logKey(e) {
                console.log(e.code);
            }
            var Postal_Code = $('#Postal_Code').val();
            var DO_NO = $('#DO_NO').val();
            var Mobile_Number = $('#Mobile_Number').val();
            var Name = $('#Name').val();
            var Remarks = $('#Remarks').val();
            var Unit_Number = $('#Unit_Number').val();
            $.ajax({
                url: 'GetAddressInfo',
                method: 'POST',
                data: {
                    Postal_Code: Postal_Code,
                    DO_NO: DO_NO,
                    Mobile_Number: Mobile_Number,
                    Unit_Number: Unit_Number,
                    Name: Name,
                    Remarks: Remarks
                },
                success: function (resultText) {
                    var resultTextArray = resultText.split('||');
                    $("#BLK_No").text(resultTextArray[0]);
                    $("#Street_Name").text(resultTextArray[1]);
                    $("#Building_Name").text(resultTextArray[2]);
                    $("#S_Postal_Code").text(resultTextArray[3]);

                },
                error: function (jqXHR, exception) {
                    console.log('Error occured!!');
                }
            });
        }

        function valuesandFocus(){
            $("#BLK_No").text("");
            $("#Street_Name").text("");
            $("#Building_Name").text("");
            $("#S_Postal_Code").text("");
        }
    </script>
    <title>Courier Details</title>
</head>
<body>
<form class="form-horizontal">
    <div class="jumbotron">
        <div class="container">
            <div class="form-group">
                <h2>Add Member Data</h2>
                <label for="DO_NO">Enter DO Number:</label>
                <div class="col-sm-8">
                    <input type="text" id="DO_NO" name="DO_NO" class="form-control"/><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Unit_Number">Enter Member's Unit Details:</label>
                <div class="col-sm-8">
                    <input type="text" id="Unit_Number" name="Unit_Number" class="form-control"/><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Postal_Code">Enter Member's Postal Code:</label>
                <div class="col-sm-8">
                    <input type="text" id="Postal_Code" name="Postal_Code" class="form-control"/><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Name">Enter Member's Name:</label>
                <div class="col-sm-8">
                    <input type="text" id="Name" name="Name" class="form-control"/><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Mobile_Number">Enter Member's Phone Number:</label>
                <div class="col-sm-8">
                    <input type="text" id="Mobile_Number" name="Mobile_Number"
                           onblur="retrieveMemberDataByMobileNumber()"
                           class="form-control"/><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Remarks">Enter Instructions:</label>
                <div class="col-sm-8">
                    <textarea id="Remarks" name="Remarks" class="form-control"></textarea><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="BLK_No">Block Number:</label>
                <div class="col-sm-8">
                    <span id="BLK_No"></span><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Street_Name">Street Name:</label>
                <div class="col-sm-8">
                    <span id="Street_Name"></span><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="Building_Name">Building Name :</label>
                <div class="col-sm-8">
                    <span id="Building_Name"></span><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="S_Postal_Code">Postal Code :</label>
                <div class="col-sm-8">
                    <span id="S_Postal_Code"></span><br/>
                </div>
            </div>

            <br/><br/>
            <div class="form-group">
                <div class="col-sm-4">
                    <input type="submit" value="Save Member details" onkeyup="retrieveAddressByPostalCode(); return false;"/>
                </div>
                <div class="col-sm-4">
                    <input type="Reset" value="Reset Member details" onkeyup="valuesandFocus()"/>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
