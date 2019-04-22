package com.pixelresolve.pixa;

import com.pixelresolve.pixa.sharedmodels.PixaUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoryInterface {
//    @GET("user/repos")
//    Call<List<Repository>> listRepos(@Header("Authorization") String accessToken,
//                                     @Header("Accept") String apiVersionSpec);
//
//    @DELETE("repos/{owner}/{repo}")
//    Call<DeletePayload> deleteRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
//                                   @Path("repo") String repo, @Path("owner") String owner);
//
//    @POST("user/repos")
//    Call<Repository> createRepo(@Body Repository repo, @Header("Authorization") String accessToken,
//                                @Header("Accept") String apiVersionSpec,
//                                @Header("Content-Type") String contentType);

    @GET("pixausers/{username}")
    Call<PixaUser> getUser(@Path("username") String username);
}
