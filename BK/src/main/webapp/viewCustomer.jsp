<!DOCTYPE html>
<html>
<head>
    <title>View Customer</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>View Customer Account</h2>
    <form action="ViewAccount" method="get">
        <label for="accountNo">Account No:</label>
        <input type="text" id="accountNo" name="accountNo" required><br><br> <!-- Updated parameter name -->
        <input type="submit" value="View">
    </form>
</body>
</html>
