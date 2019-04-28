package com.example.wing_it.network;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;

import com.example.wing_it.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class SampleHelper implements View.OnClickListener {

        private Activity activity;
        private int theme = R.style.AppTheme_Splash;

        private SampleHelper(Activity activity) {
            this.activity = activity;
        }

        public static SampleHelper with(Activity activity) {
            return new SampleHelper(activity);
        }

        public SampleHelper init() {
            activity.setTheme(theme);

            activity.findViewById(R.id.dark).setOnClickListener(this);
            activity.findViewById(R.id.light).setOnClickListener(this);
            activity.findViewById(R.id.custom).setOnClickListener(this);

            return this;
        }

        public void loadAshleyAbout() {

            final ConstraintLayout cHolder = activity.findViewById(R.id.ashleyfrag);

            AboutBuilder AshleyView = AboutBuilder.with(activity)
                    .setPhoto(R.drawable.ashley)
//                .setCover(R.mipmap.profile_cover)
                    .setName("Ashley L.")
                    .setSubTitle("Android Developer")
                    .setBrief("I am a twenty-six year old West-Indian American woman currently working" +
                            "in mental health services. Joing pursuit seemed like an awesome opportunity to develop a diverse," +
                            "relevant and competitive skillset, I hope to grow personally from this experience" +
                            "and also reconcole my passions with the dynamism of technology. My favorite hobbies include" +
                            "cooking, socializing and cosmetic artistry")
                    .addGitHubLink("AMCL9")
                    .addLinkedInLink("ashley-lewis-444515174")
                    .addFiveStarsAction()
                    .setWrapScrollView(true)
                    .setLinksAnimated(true)
                    .setShowAsCard(true);

            AboutView view = AshleyView.build();

            cHolder.addView(view);
        }
            public void loadGregAbout() {

                final ConstraintLayout cHolder = activity.findViewById(R.id.gregfrag);

                AboutBuilder greggView = AboutBuilder.with(activity)
                        .setPhoto(R.drawable.greg)
//                .setCover(R.mipmap.profile_cover)
                        .setName("Gregg N.")
                        .setSubTitle("Android Developer")
                        .setBrief("Currently, I work as a teacher's aide for the Dept of Education. I joined Pursuit to " +
                                "fulfill my dream of becoming a programmer. I want to be able to code in Java to the point that " +
                                "it becomes muscle memory. I also hope to make connections with fellow tech-oriented people." +
                                "I enjoy doing tough mudders, Cross Fit, and transcendental meditation.")
                        .addGitHubLink("GreggNicholas")
                        .addLinkedInLink("gregg-nicholas")
                        .addFiveStarsAction()
                        .setWrapScrollView(true)
                        .setLinksAnimated(true)
                        .setShowAsCard(true);


                AboutView view = greggView.build();

                cHolder.addView(view);
            }
                public void loadEnriqueAbout() {

            final ConstraintLayout cHolder = activity.findViewById(R.id.enriquefrag);
                    AboutBuilder EnriqueView = AboutBuilder.with(activity)
                            .setPhoto(R.drawable.enrique)
//                .setCover(R.mipmap.profile_cover)
                            .setName("Enrique C.")
                            .setSubTitle("Android Developer")
                            .setBrief("I am perservering, and resilient when it comes to facing hard challenges." +
                                    "I joined pursuit so I can have an opportunity to show my loved ones what I am capable " +
                                    "of doing but also to show myself that I can achieve my list of impossible tasks. Fun Fact: I " +
                                    "enjoy collecting Yugioh cards and playing board games with friends")
                            .addGitHubLink("enricky13")
                            .addLinkedInLink("enrique-cruz-95513aa1")
                            .addFiveStarsAction()
                            .setWrapScrollView(true)
                            .setLinksAnimated(true)
                            .setShowAsCard(true);

                    AboutView view = EnriqueView.build();

                    cHolder.addView(view);
                }
                    public void loadBenAbout() {

            final FrameLayout flHolder = activity.findViewById(R.id.benfrag);

                        AboutBuilder BenView = AboutBuilder.with(activity)
                                .setPhoto(R.drawable.ben)
//                .setCover(R.mipmap.profile_cover)
                                .setName("Ben B.")
                                .setSubTitle("Android Developer")
                                .setBrief("My plans are to be an Android app developer because" +
                                        "I really love to see my imagination come to life. I chose to learn" +
                                        "android development and intend to work at a tech company because a stimulating" +
                                        "work-space is cucial in order to get more experience in the short term and grow " +
                                        "my skill swt and try new things, and learn from the best. Above all, I enjoy" +
                                        "wearing multiple hats. With these kinds of skills, knowledge and experience, I can " +
                                        "build my own computing and IT consulting solutions complany with 5-7 years. In the long term" +
                                        "I hope to earn a Ph. D in computer science.")
                                .addGitHubLink("benrabaa")
                                .addLinkedInLink("m-benrabaa/")
                                .addFiveStarsAction()
                                .setWrapScrollView(true)
                                .setLinksAnimated(true)
                                .setShowAsCard(true);


            AboutView view = BenView.build();

            flHolder.addView(view);
        }


        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.dark:
                    if (theme != R.style.AppTheme_Splash) {
                        theme = R.style.AppTheme_Splash;
                        activity.recreate();
                    }
                    break;
                case R.id.light:
                    if (theme != R.style.AppTheme_Splash) {
                        theme = R.style.AppTheme_Splash;
                        activity.recreate();
                    }
                    break;

                case R.id.custom:
                    if (theme != R.style.AppTheme_Splash) {
                        theme = R.style.AppTheme_Splash;
                        activity.recreate();
                    }
                    break;

                default:
                    break;
            }
        }
    }


