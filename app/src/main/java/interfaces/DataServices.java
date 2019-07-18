package interfaces;

import java.util.List;

import model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by User on 7/17/2019.
 */

public interface DataServices
{
    String sub_url = "";

    @GET(sub_url + "userlogin/user_login")
    Call<List<LoginResponse>> userLogin(@Query("un") String username, @Query("pwd") String password);
}
