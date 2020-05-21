package com.oman.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariantOutput;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.File;

/**
 * @author:ZhouJiang
 * @date:2020/5/21 22:28
 * @email:zhoujiang2012@163.com
 */
public class AutoJiaguPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        /**
         * auto 是为了在使用的时候配置的
         * ConfigModel 是一个包含了配置信息的类
         * 这样我们就可以得到app中的配置信息
         */
        ConfigModel model = project.getExtensions().create("auto", ConfigModel.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                /**
                 * 下列操作是为了获取我们需要加固的apk的文件
                 */
                AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
                appExtension.getApplicationVariants().all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(ApplicationVariant applicationVariant) {
                        applicationVariant.getOutputs().all(new Action<BaseVariantOutput>() {
                            @Override
                            public void execute(BaseVariantOutput variantOutput) {
                                File outputFile = variantOutput.getOutputFile();
                                String name = variantOutput.getName();
                                if ("release".equals(name)) {
                                    project.getTasks().create("autoJiagu", AutoJiaguTask.class, outputFile, model);
                                }
                            }
                        });
                    }
                });
            }
        });
    }
}
