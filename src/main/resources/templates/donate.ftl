<!DOCTYPE html>
<html>
  <#assign title="Sumbangan">
  <#include "head.ftl">
  <body>
    <section class="section">
      <form class="container" action="/donate" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <!-- NAME FIELD -->
        <div class="field">
          <label class="label">Nama</label>
          <div class="control">
            <input class="input<#if (name_null_error!name_size_error)??> is-danger</#if>" type="text" name="name" placeholder="Nama" value="${(donationForm.name)!""}">
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

        <!-- AMOUNT FIELD -->
        <div class="field">
          <label class="label">Jumlah sumbangan</label>
          <div class="control">
            <input class="input<#if (amount_null_error!amount_format_error)??> is-danger</#if>" type="text" name="amount" placeholder="Jumlah sumbangan" value="${(donationForm.amount)!"5.00"}">
          </div>
          <#if amount_null_error??>
            <p class="help is-danger">
              Jumlah sumbangan tidak boleh kosong
            </p>
          </#if>
          <#if amount_format_error??>
            <p class="help is-danger">
              Jumlah sumbangan mesti dalam format nombor, contohnya 5.00
            </p>
          </#if>
        </div>

        <!-- EMAIL FIELD -->
        <div class="field">
          <label class="label">Email (tidak wajib)</label>
          <div class="control">
            <input class="input<#if email_format_error??> is-danger</#if>" type="text" name="email" placeholder="Email (tidak wajib)" value="${(donationForm.email)!""}">
          </div>
          <#if email_format_error??>
            <p class="help is-danger">
              Email mesti dalam format email
            </p>
          </#if>
        </div>

        <!-- MESSAGE FIELD -->
        <div class="field">
          <label class="label">Pesanan (tidak wajib)</label>
          <div class="control">
            <textarea class="textarea<#if (message_null_error!message_size_error)??> is-danger</#if>" name="message" placeholder="Tulis kandungan email di sini...">${(donationForm.message)!""}</textarea>
          </div>
          <#if message_null_error??>
            <p class="help is-danger">
              Kandungan email tidak boleh null
            </p>
          </#if>
          <#if message_size_error??>
            <p class="help is-danger">
              Kandungan email tidak boleh melebihi 2000 abjad
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
