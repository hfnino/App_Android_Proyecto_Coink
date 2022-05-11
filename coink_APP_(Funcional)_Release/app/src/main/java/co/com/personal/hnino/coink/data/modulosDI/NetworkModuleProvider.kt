package co.com.personal.hnino.coink.data.modulosDI

import co.com.personal.hnino.coink.data.network.ItemTipoGeneroApiClientInterface
import co.com.personal.hnino.coink.data.network.ItemTipoIdentifApiClientInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object NetworkModuleProvider {

    @Singleton
    @Provides
    fun provideTiposIdentifRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.bancoink.biz/qa/signup/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit
    }

    @Singleton
    @Provides
    fun provideItemTipoIdentifApiClient(retrofit: Retrofit): ItemTipoIdentifApiClientInterface {

        return retrofit.create(ItemTipoIdentifApiClientInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideItemTipoGeneroApiClient(retrofit: Retrofit): ItemTipoGeneroApiClientInterface {

        return retrofit.create(ItemTipoGeneroApiClientInterface::class.java)
    }
}