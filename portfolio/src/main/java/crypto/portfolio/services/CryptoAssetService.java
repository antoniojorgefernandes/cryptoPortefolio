package crypto.portfolio.services;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoAssetService {
	private static String apiKey = "d8331e50-9752-4934-8888-bf956e621ba6";

    private final String uriForCryptoAssetInfo = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info";
    private final String uriForCryptoAssetPrice = "https://pro-api.coinmarketcap.com//v1/cryptocurrency/quotes/latest";


    public String getTokenInfo (String tokenSymbol)
		  throws URISyntaxException, IOException {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("symbol",tokenSymbol));
		String response_content = "";
	
		URIBuilder query = new URIBuilder(uriForCryptoAssetInfo);
		query.addParameters(parameters);
	
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(query.build());
	
		request.setHeader(HttpHeaders.ACCEPT, "application/json");
		request.addHeader("X-CMC_PRO_API_KEY", apiKey);
	
		CloseableHttpResponse response = client.execute(request);
	
		try {
		  HttpEntity entity = response.getEntity();
		  response_content = EntityUtils.toString(entity);
		  EntityUtils.consume(entity);
		} finally {
		  response.close();
		}
        
		return response_content;
	  }

      public String getTokenPrice (String tokenSymbol)
		  throws URISyntaxException, IOException {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("symbol",tokenSymbol));
		String response_content = "";
	
		URIBuilder query = new URIBuilder(uriForCryptoAssetPrice);
		query.addParameters(parameters);
	
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(query.build());
	
		request.setHeader(HttpHeaders.ACCEPT, "application/json");
		request.addHeader("X-CMC_PRO_API_KEY", apiKey);
	
		CloseableHttpResponse response = client.execute(request);
	
		try {
		  HttpEntity entity = response.getEntity();
		  response_content = EntityUtils.toString(entity);
		  EntityUtils.consume(entity);
		} finally {
		  response.close();
		}
	
		return response_content;
	  }
}
