package utilsPOC;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.getbullish.centralProcessingEngine.repos.StockRepo;

@Service
public class URLcsvdownloader {
  @Autowired
  StockRepo repo;

  public void startdownload() {

  }



  public void client(String url) throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    // https://www.nseindia.com/api/corporates-financial-results?index=equities
    try {


      HttpGet request = new HttpGet(url);

      request.addHeader(HttpHeaders.USER_AGENT,
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36");
      request.addHeader(HttpHeaders.ACCEPT,
          "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

      request.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate, br");

      request.addHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");

      request.addHeader(HttpHeaders.CACHE_CONTROL, "max-age=0");


      request.addHeader("upgrade-insecure-requests:", "1");

      request.addHeader("cookie",
          "_ga=GA1.2.1923734728.1620988702; _gid=GA1.2.245872412.1622198307; nseQuoteSymbols=[{\"symbol\":\"JUSTDIAL\",\"identifier\":null,\"type\":\"equity\"}]; bm_mi=79AAD316B873ED3DF11C8792763B3B1E~Bmm4H5royrlUtDusXUOF3pmcGed46B5w88KdqbVbc9zEnkAuFY+sijWx86Z0KSfwqV6nqL+Dz6IFMAgFKR2tyD1hcr71LcSeGMOEWajWj/Bo7A3nadmUOq2XvkWQHPdVjdaaPyExdB3q/VhFPaSx2X7hngLKZfOXCip8uc+FjpjL7lTUpeFKrGwQ7DgJj0ahjSB1Rcf/Lg1DVylLyJizCQhlxg4yyEiu0lWDxIwX9cC2f3lKpIfzOHmpeHtwZN+I93BTGcnZcHDBzCv0LTP5Hqa99yTR/4mSDmpqguDm3lM=; ak_bmsc=0B9E1AAEDFA9E8A8217F865D687D52EB17D4FDA49C1D00006C63B260E06AF759~plV5Nw2ZBDgSYANvtAEf5kgY6BXB6eK6vfj2VMmsR99KraMiQejKwfrb4niYkcZVWIOdFDFBn9PlZs0eO5LpFNTcpFeMiX6EDqTFZfk0COtAj2foCAcn0d1giCfJxeNzHyZFyh9w+6knc61ecszPdk0krXTqExhJEr4onng6SyXh1h/wzeKGaD5f48iIlg0MECUF99MjYX7GO716UNFv7YHamQOpjotQ6OXxVhGAH5+f1rI5Swca/pM+qlNTvaPKPk; AKA_A2=A; nsit=t1tg433cSZ-GECweOlluu_4Z; nseappid=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhcGkubnNlIiwiYXVkIjoiYXBpLm5zZSIsImlhdCI6MTYyMjMwODczMCwiZXhwIjoxNjIyMzEyMzMwfQ.mCd6UU2k6KqR5chWQgVkqF8ZJ82_KbPvGZVxU5tTGqA; RT=\"z=1&dm=nseindia.com&si=beb86349-1a21-4d13-80c7-ed35ceb46502&ss=kpa07y8s&sl=2&tt=7ka&bcn=%2F%2F684d0d3e.akstat.io%2F&ld=igdf&ul=nvs9&hd=nvsq\"; bm_sv=B00650FA2165ADFE268BA76343BF1548~zrlw/WaALM9ChynU+9k+pRcl9mSz0f+h5hr0JzRNWYw4SCD+9oe8k30PEi9RLGtdxJztjqpwvuo+8YQJU0lbJp5KavQYkEmuowrM/cddMDtjEF/9TYFNqSEgtts88FcHSSEGmSdESh8umyKxofsOukRIz6gD8HTFOvhpQSUn11A=");



      CloseableHttpResponse response = httpClient.execute(request);
      System.out.println("-------------");
      try {

        // Get HttpResponse Status
        System.out.println(response.getProtocolVersion()); // HTTP/1.1
        System.out.println(response.getStatusLine().getStatusCode()); // 200
        System.out.println(response.getStatusLine().getReasonPhrase()); // OK
        System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

        HttpEntity entity = response.getEntity();
        if (entity != null) {
          // return it as a String
          String result = EntityUtils.toString(entity);
          System.out.println("---result--");
          System.out.println(result);
        }

      } finally {
        response.close();
      }
    } finally {
      httpClient.close();
    }

  }
}


