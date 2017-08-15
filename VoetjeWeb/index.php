<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Voetje Online</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/style.css" rel="stylesheet" media="screen">
        
    </head>
    <body>
        <div class="navbar navbar-static-top">
            <div class="navbar-inner">
                <a class="brand" href="#" >Voetje Online</a>
                <ul class="nav">
                    <li><a href="#">Home</a></li>
                </ul>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <select id="codelist" onchange="listValueChanged($(this).val(),$('#inputtext').val());">
                        <option value="raam">raam</option>
                        <option value="braille">braille</option> 
                        <option value="chinees">chinees</option> 
                        <option value="handen">handen</option> 
                        <option value="ladder">ladder</option> 
                        <option value="morse">morse</option> 
                    </select>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="">
                        <h3>Input tekst</h3>
                    </div>
                    <div class="">
                        <textarea id="inputtext" class="stretch" onkeyup="inputTextValueChanged($(this).val(),$('#codelist').val());" ></textarea>
                    </div>
                </div>
                <div class="span6">
                    <div class="">
                        <h3>Output tekst</h3>
                    </div>
                    <div class="">
                        <textarea id="outputtext" class="stretch" ></textarea>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/voetje.js" type="text/javascript" />
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            changeOutputFont("voetje_raam");
        </script>
    </body>
</html>
