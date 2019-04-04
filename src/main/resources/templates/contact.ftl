<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hubungi Kami</title>
  </head>
  <body>
    <#list errors![]>
      <ul>
        <#items as error>
          <li>${error}</li>
        </#items>
      </ul>
    </#list>
    <form action="/contact" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <input type="text" name="name" placeholder="Nama">
      <br/>
      <input type="text" name="from" placeholder="Email (tidak wajib)">
      <br/>
      <textarea name="content" placeholder="Tulis kandungan email di sini..."></textarea>
      <br/>
      <input type="submit" value="Hantar Email">
    </form>
  </body>
</html>
