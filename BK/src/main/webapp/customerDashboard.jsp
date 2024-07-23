<!DOCTYPE html>
<html>
<head>
    <title>Customer Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Customer Dashboard</h2>
    <div class="container">
        <h3>Welcome ${sessionScope.full_name}</h3>
        <a href="deposit.jsp">Deposit</a>
        <a href="withdraw.jsp">Withdraw</a>
        <a href="CheckBalanceServlet">Check Balance</a>
        <a href="TransactionHistoryServlet">Transaction History</a>
        <a href="changePassword.jsp">ChangePassword</a>
        <form action="DeleteAccountServlet" method="post" onsubmit="return confirm('Are you sure you want to delete your account?');">
            <button type="submit">Delete Account</button>
        </form>
        <a href="LogoutServlet">Logout</a>
    </div>
</body>
</html>
