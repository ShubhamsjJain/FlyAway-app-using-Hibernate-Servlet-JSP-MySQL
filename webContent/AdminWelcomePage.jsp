<!DOCTYPE html>
<html>
<head>
<style>
button {
  background-color: black;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 180px;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}
body {
  background-image: url('adminback.jfif');
  background-repeat: no-repeat;
  background-attachment: fixed;  
   background-size: cover;
  
}

input[type="text"],input[type="submit"],input[type="Date"],select
{
    font-size:20px;
}
label{
 font-size:24px;
}

.right-align {
text-align: right;
}

</style>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>

<h1>Welcome Admin!</h1>

    <div class="right-align">
        <button type="button" class="cancelbtn" onclick="window.location.href='index.html';return false;">Logout</button>
    </div>
    
<hr>

<button type="button" onclick="location.href='add-flight-form.jsp'">Add New Flight</button>
<button type="button" onclick="location.href='AdminFlightSearch.jsp'">All Flight Info</button>

</body>
</html>