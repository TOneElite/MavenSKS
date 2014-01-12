<style>
    #pass-input{
        background-color: #f3ede1;
        padding: 1%; 
    }
    label{
        display: inline-block;
        width: 130px;
        margin: 5px;
    }
    #pass-button{
        margin-top: 5px;
        margin-left: 207px;
        width: 90px;
        height: 25px;
    }
</style>
<section id="pass-input">
    <form:form method="post" modelAttribute="changePass" action="checkPass">
        <form:errors path="*" />
        <br><label>Gammelt passord:</label>
        <form:input path="oldPass" />
        <form:errors path="oldPass" />
        <input type="password" name="" value="">
        <br><label>Nytt passord:</label>
        <form:input path="newPass" />
        <form:errors path="newPass" />
        <input type="password" name="" value="">
        <br><label>Gjenta nytt passord:</label>
        <form:input path="newPass" />
        <form:errors path="newPass" />
        <input type="password" name="" value="">
        <br><input type="submit" id="pass-button" value="Bytt passord">
    </form:form>
</id>