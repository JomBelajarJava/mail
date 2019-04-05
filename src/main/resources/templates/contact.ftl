<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hubungi Kami</title>
    <link rel="stylesheet" href="https://unpkg.com/bulma@0.7.4/css/bulma.min.css">
  </head>
  <body>
    <section class="section">
      <form class="container" action="/contact" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <!-- NAME FIELD -->
        <div class="field">
          <label class="label">Nama</label>
          <div class="control">
            <input class="input<#if (name_null_error!name_size_error)??> is-danger</#if>" type="text" name="name" placeholder="Nama" value="${(contactForm.name)!""}">
          </div>
          <#if name_null_error??>
            <p class="help is-danger">
              Nama tidak boleh null
            </p>
          </#if>
          <#if name_size_error??>
            <p class="help is-danger">
              Nama tidak boleh kosong dan tidak melebihi 100 abjad
            </p>
          </#if>
        </div>

        <!-- EMAIL FIELD -->
        <div class="field">
          <label class="label">Email (tidak wajib)</label>
          <div class="control">
            <input class="input<#if email_format_error??> is-danger</#if>" type="text" name="email" placeholder="Email (tidak wajib)" value="${(contactForm.email)!""}">
          </div>
          <#if email_format_error??>
            <p class="help is-danger">
              Email mesti dalam format email
            </p>
          </#if>
        </div>

        <!-- CONTENT FIELD -->
        <div class="field">
          <label class="label">Kandungan</label>
          <div class="control">
            <textarea class="textarea<#if (content_null_error!content_size_error)??> is-danger</#if>" name="content" placeholder="Tulis kandungan email di sini...">${(contactForm.content)!""}</textarea>
          </div>
          <#if content_null_error??>
            <p class="help is-danger">
              Kandungan email tidak boleh null
            </p>
          </#if>
          <#if content_size_error??>
            <p class="help is-danger">
              Kandungan email tidak boleh kosong dan tidak melebihi 2000 abjad
            </p>
          </#if>
        </div>

        <!-- SUBMIT BUTTON -->
        <div class="field">
          <div class="control">
            <input class="button is-link" type="submit" value="Hantar Email">
          </div>
        </div>
      </form>
    </section>
  </body>
</html>
