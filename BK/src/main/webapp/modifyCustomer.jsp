<!DOCTYPE html>
<html>
<head>
    <title>Modify Customer</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Modify Customer Account</h2>
    <form action="ModifyAccount" method="post">
        <label for="accountNo">Account No:</label>
        <input type="text" id="accountNo" name="accountNo" required><br><br>
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required><br><br>
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br><br>
        <label for="mobileNo">Mobile No:</label>
        <input type="text" id="mobileNo" name="mobileNo" required><br><br>
        <label for="emailId">Email ID:</label>
        <input type="email" id="emailId" name="emailId" required><br><br>
        <label for="accountType">Account Type:</label>
        <select id="accountType" name="accountType">
            <option value="Saving">Saving Account</option>
            <option value="Current">Current Account</option>
        </select><br><br>
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br><br>
        <label for="idProof">ID Proof:</label>
        <input type="text" id="idProof" name="idProof" required><br><br>
        <input type="submit" value="Modify">
    </form>
</body>
</html>
