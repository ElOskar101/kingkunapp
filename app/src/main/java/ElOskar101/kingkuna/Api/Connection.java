package ElOskar101.kingkuna.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection {

    private static String URL = "http://www.kingkuna.somee.com/api";

    //private static String URL = "http://192.168.43.105:49677/api";

    public static String getBase (){
        return URL + "/";
    }

    public static Service instance (){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Connection.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);

    }

}
