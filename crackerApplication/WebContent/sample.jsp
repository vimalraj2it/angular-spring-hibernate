<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

    <html>
      <body>
        <form action="" method="post">
        <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfJdwcTAAAAAJ0RbfIQog1UCekTOiQH7H3ONWO3", "6LfJdwcTAAAAAIXk8Xzp9UPTyzo8CJ5yI4i1Ny_f", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
        </form>
      </body>
    </html>