package cnwir.com.baseprj;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by heaven on 2015/5/15.
 */
public class App extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        initImageLoad(sContext);
            LeakCanary.install(this);
    }

    public static Context getContext() {

        return sContext;
    }

    /**
     * 初始化Android-Universal-Image-Loader 配置
     * 文档地址 https://github.com/nostra13/Android-Universal-Image-Loader
     */
    private static void initImageLoad(Context context) {

            // This configuration tuning is custom. You can tune every option, you may tune some of them,
            // or you can create default configuration by
            //  ImageLoaderConfiguration.createDefault(this);
            // method.
            ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
            config.threadPriority(Thread.NORM_PRIORITY - 2);
            config.denyCacheImageMultipleSizesInMemory();
            config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
            config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
            config.tasksProcessingOrder(QueueProcessingType.LIFO);
            config.writeDebugLogs(); // Remove for release app

            // Initialize ImageLoader with configuration.
            ImageLoader.getInstance().init(config.build());
    }
}
