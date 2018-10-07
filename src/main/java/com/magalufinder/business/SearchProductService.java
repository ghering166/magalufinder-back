

package com.magalufinder.business;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
	
@Service
public class SearchProductService implements Serializable  {

	public void prepareListStores() {
		RestTemplate restTemplate = new RestTemplate();
		
	}
	
	public String mountUrlLocalization() {
		StringBuilder url = new StringBuilder();
		url.append("https://maps.googleapis.com/maps/api/geocode/json?address=");
		return "";
	}
	
	public long getDriveDist(String addrOne, String addrTwo) throws ApiException, InterruptedException, IOException{
		
		//set up key
	   	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey("AIzaSyDHQK4QkkI03DtshOCz7w6lZqCLRSX-OXs")
			    .build();
	   	
	   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	       DistanceMatrix result = req.origins(addrOne)
	               .destinations(addrTwo)
	               .mode(TravelMode.DRIVING)
	               .avoid(RouteRestriction.TOLLS)
	               .language("en-US")
	               .await();
	       
				long distApart = result.rows[0].elements[0].distance.inMeters;
		
		return distApart;
	}
	
//	public String montarUrlLocalizacao(CepTO cepTO) {
//	StringBuilder url = new StringBuilder();
//	url.append("https://maps.googleapis.com/maps/api/geocode/json?address=");
//	if (!UtilFaces.isPreenchimentoNuloOuVazio(cepTO.getLogradouro())) {
//		url.append(cepTO.getLogradouro().concat(","));
//	}
//	if (!UtilFaces.isPreenchimentoNuloOuVazio(cepTO.getCep())) {
//		url.append(cepTO.getCep().concat(","));
//	}
//	if (!UtilFaces.isPreenchimentoNuloOuVazio(cepTO.getLocalidade())) {
//		url.append(cepTO.getLocalidade().concat(","));
//	}
//	if (!UtilFaces.isPreenchimentoNuloOuVazio(cepTO.getUf())) {
//		url.append(cepTO.getUf().concat(","));
//	}
//	System.out.println(url.toString().concat("&key=AIzaSyDHQK4QkkI03DtshOCz7w6lZqCLRSX-OXs").replaceAll(",&", "&"));
//	return url.toString().concat("&key=AIzaSyDHQK4QkkI03DtshOCz7w6lZqCLRSX-OXs").replaceAll(",&", "&");
//}
	
	// Lookups up and returns the address of an establishment given its name and possible some location attributes
		public String lookupAddr(String establishment) throws ApiException, InterruptedException, IOException {
			
			//set up key
			GeoApiContext lookupDoodad = new GeoApiContext.Builder()
				    .apiKey("")
				    .build();
				GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
				    establishment).await();
				
				//converts results into usable address
				
				String address = (results[0].formattedAddress);
			
			return address;
		}
		
		// Lookups up and returns the coordinates of an establishment given its name and possible some location attributes
		public LatLng lookupCoord(String establishment) throws ApiException, InterruptedException, IOException {
				
			//set up key
			GeoApiContext lookupDoodad = new GeoApiContext.Builder()
				    .apiKey("")
				    .build();
			GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
			  establishment).await();
					
				//converts results into usable Coordinates
			
				LatLng coords = (results[0].geometry.location);
					//System.out.println(results[0].geometry.location);
			return coords;
		}
		
		// Why was this added??
		public void distanceMatrix(String[] origins, String[] destinations) throws ApiException, InterruptedException, IOException{
			GeoApiContext context = new GeoApiContext.Builder()
				    .apiKey("")
				    .build();
				
				DistanceMatrixApiRequest req=DistanceMatrixApi.newRequest(context);
				DistanceMatrix t=req.origins(origins).destinations(destinations).mode(TravelMode.DRIVING).await();
				//long[][] array=new long[origins.length][destinations.length];
				File file=new File("Matrix.txt");
				FileOutputStream out=new FileOutputStream(file);
				DataOutputStream outFile=new DataOutputStream(out);
				for(int i=0;i<origins.length;i++){
					for(int j=0;j<destinations.length;j++){
						//System.out.println(t.rows[i].elements[j].distance.inMeters);
						outFile.writeLong(t.rows[i].elements[j].distance.inMeters);
					}
				}
				outFile.close();
		}
	
}
