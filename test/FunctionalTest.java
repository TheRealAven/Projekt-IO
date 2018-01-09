import org.junit.Test;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalTest extends WithApplication {

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Aplikacja o budynkach");
        assertThat("text/html").isEqualTo(html.contentType());
        assertThat(html.body()).contains("Aplikacja o budynkach");
    }
}
