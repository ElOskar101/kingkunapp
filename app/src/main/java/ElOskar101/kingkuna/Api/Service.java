package ElOskar101.kingkuna.Api;

import ElOskar101.kingkuna.Models.Client;
import ElOskar101.kingkuna.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {

    /*Commentary entities methods for API Service
    @GET("pictures/friends/myuser/{id}")
    Call<List<User>> getPicture(@Path("id") String userID);*/

    @Headers({"Accept: application/json"})
    @POST("login/authenticate")
    Call<User> getToken(@Body User user);

    @GET("clients")
    Call<Client> getClients(@Path("id") int clientID, @Header("Authorization") String token);

    @POST("clients")
    Call<Client> postClient(@Body Client client, @Header("Authorization") String token);

    //@POST("")

}
