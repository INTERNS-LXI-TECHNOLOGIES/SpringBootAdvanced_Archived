<!DOCTYPE html>
<html>
   <head>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script>
         function functionAlert(msg, myYes) {
            var confirmBox = $("#confirm");
            confirmBox.find(".message").text(msg);
            confirmBox.find(".yes").unbind().click(function() {
               confirmBox.hide();
            });
            confirmBox.find(".yes").click(myYes);
            confirmBox.show();
         }
      </script>
      <style>
         #confirm {
            display: none;
            background-color: #F3F5F6;
            color: #000000;
            border: 1px solid #aaa;
            position: fixed;
            width: 300px;
            height: 100px;
            left: 50%;
            margin-left: -100px;
            padding: 10px 20px 10px;
            box-sizing: border-box;
            text-align: center;
         }
         #confirm button {
            background-color: #FFFFFF;
            display: inline-block;
            border-radius: 12px;
            border: 4px solid #aaa;
            padding: 5px;
            text-align: center;
            width: 60px;
            cursor: pointer;
         }
         #confirm .message {
            text-align: left;
         }
      </style>
   </head>
   <body>
      <div id="confirm">
         <div class="message">This is a warning message.</div>
            <button class="yes">OK</button>
         </div>
      <input type="button" value="Click Me" onclick="functionAlert();" />
   </body>
</html>