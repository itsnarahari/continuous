package com.continuous.practice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadUrl {
    public static void main(String[] args) throws IOException {
        String arr[]={
        "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/1/1711895892489?e=1712793600&v=beta&t=wCkW7rdlEUK1PeKwYndm7Kq0QOmBoxxsqiQ3nT30t10",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/2/1711895892489?e=1712793600&v=beta&t=RdRc1pizs8H_gAAOR0Kg5Cc991wVro-lOWE-3bP5Bgk",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/3/1711895892489?e=1712793600&v=beta&t=lIPJeWa9TQAxefJ_Vyr4rtLniBYXu4utn1v4Ef5r6Lc",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/4/1711895892489?e=1712793600&v=beta&t=pIaNIHQYlmyG_jbCp2gTFiZYWRTBsSJwUfE3JNRcARs",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/5/1711895892489?e=1712793600&v=beta&t=URp2ftoP_GraB22yYwQ0ZwdHhW_C7Duz8sQohJfVXVU",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/6/1711895892489?e=1712793600&v=beta&t=0rtlyOPkHc3e2whcqLU8sgy9J6S4wQdki1hfcsaJqVw",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/7/1711895892489?e=1712793600&v=beta&t=MXK7bvGX8hFRstxj5Zo3V3BHcc7eoSxR5dAm3h1siXg",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/8/1711895892489?e=1712793600&v=beta&t=6dIuuC7s0F2_fvD6FiV3Ih4z7b_Nd-pMVSS429_S9vI",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/9/1711895892489?e=1712793600&v=beta&t=1zL1d6d2xvL6wP_hS_bbMt_YmYxIjjwYoa_X9Mq1n08",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/10/1711895892489?e=1712793600&v=beta&t=YnYlZSp_OHKiSqlfk8Yci5tnsYnRnzHhZHung_uPVqY",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/11/1711895892489?e=1712793600&v=beta&t=csdlbGXjSK8CRY4XDxycWLYvyOiNzj_uHH6-EogALjU",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/12/1711895892489?e=1712793600&v=beta&t=ov6UfJxCr0HokjgF9ALIJggB66Au8GQyHv9Tcjse9sQ",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/13/1711895892489?e=1712793600&v=beta&t=r915pi364cKY5BE9j5VsN-kaPcOiEb0ZbXIhiwZpxWE",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/14/1711895892489?e=1712793600&v=beta&t=6_P0enx62UhSFqEr7wEfw2--mm5AQarrN3HxDMtJoto",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/15/1711895892489?e=1712793600&v=beta&t=m6vUrMtEeiDGr6cCLvJ1NwP6nWy-kUJsmbU0CNgfJd4",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/16/1711895892489?e=1712793600&v=beta&t=0arrErPxalVOlUqzZiZN0RhKUoxKyx7pwKpcck8_ZVI",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/17/1711895892489?e=1712793600&v=beta&t=BTgRX1rbtKVEVyxYtMGYHTB09i18x6x4fR4VEVH8aMg",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/18/1711895892489?e=1712793600&v=beta&t=LSj8MtvnWP0ctpCsBb-CiJ1rHB2gT4zaguYkPakRnbU",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/19/1711895892489?e=1712793600&v=beta&t=p5-8leh7yynS9jRHCnP_IdPsCuUxXGaNd6Mob4pKuzI",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/20/1711895892489?e=1712793600&v=beta&t=IEcjTjpmBCybahM5gpK3aUufUJ2rNgzDvesqO866-8Y",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/21/1711895892489?e=1712793600&v=beta&t=ZYyekbRZ6oQsp0N9b2i8Vz34CCipA6uqTg8VFfo3PN8",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/22/1711895892489?e=1712793600&v=beta&t=1DPiR1846LeAH1e_gxvcaDulymWQyx7xUSXyfQyfmZc",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/23/1711895892489?e=1712793600&v=beta&t=IUIqQT4vlIkvpwxJrUqTrv7jruArt4aVLh1W5glu_ko",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/24/1711895892489?e=1712793600&v=beta&t=bbAfVoJeRcmE2yoFI_NeBX6HSPD6dx-7YbQiE5kSXLg",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/25/1711895892489?e=1712793600&v=beta&t=KAkJg9dCdelId7Wd-vdyjv1wyHhRCzUCHiticM1XugA",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/26/1711895892489?e=1712793600&v=beta&t=U-sWlKO1iHMQjpWPpPpauht8XnAyvbh65NQB8kw0TVo",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/27/1711895892489?e=1712793600&v=beta&t=7dFmqeB3fqQt1O_9Wy7d71JNDeYO2g3JEFHgpxF_MAo",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/28/1711895892489?e=1712793600&v=beta&t=VOLZm0ReL-6yJHpuYQBjY1kv6ciG0lpdbOR9z6UEqPc",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/29/1711895892489?e=1712793600&v=beta&t=qfZoYI9SAip60bm_Ui_r_qx_k0lxPUulOBlF_FgT7D8",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/30/1711895892489?e=1712793600&v=beta&t=yTUp29ipPYAoxVdEYrAE7PhyBkq8pvOzg5pQt3Nv648",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/31/1711895892489?e=1712793600&v=beta&t=G5zB6JPGdAWs9a4qD1Nd1ulsns5zDY3lrh0lurXQ7h4",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/32/1711895892489?e=1712793600&v=beta&t=Uq98AzeVzuGgjnY3FFpkCwOd3bEeCpH3qQ54RkTWXjk",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/33/1711895892489?e=1712793600&v=beta&t=CbvBHhKfDrA-g2eeqmA9PnJxWQSREtWxGRv3sM-NbTY",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/34/1711895892489?e=1712793600&v=beta&t=U_t64qw2RCkPDjIEZw059DxS41kk_KnEPDj1q54v5kM",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/35/1711895892489?e=1712793600&v=beta&t=KESFTdMw5f9tXMlXCLg2w52Pu5-Zoat2U7TRtUPjueA",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/36/1711895892489?e=1712793600&v=beta&t=C94wPRghfJnj1nRfanXetPw0QzLkobZy-JExwl4mBBU",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/37/1711895892489?e=1712793600&v=beta&t=eOQbvRPgLmEGsSLQOVMYSLsJCOfPyF0X0HP-LElR91E",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/38/1711895892489?e=1712793600&v=beta&t=-0L_ERIUbtVeJvwof6gy_bN6XUdQCnQ299z9LzjXhdg",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/39/1711895892489?e=1712793600&v=beta&t=CQfdRzgjERA_KvIS6A5fg3BQSMxvLPY2FxmZHRKNQto",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/40/1711895892489?e=1712793600&v=beta&t=ya4DnlusRtFC_YnsI_cNsJrc2PbMM4d0vG3akwveXKE",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/41/1711895892489?e=1712793600&v=beta&t=mt6ZZYTukfKMYxpHB2VuT8UrQIGu356VJUBequNbmeg",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/42/1711895892489?e=1712793600&v=beta&t=FiLtFNVNK9V0eV87oPiomT7SW76nONRKNI1MbCJuyJs",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/43/1711895892489?e=1712793600&v=beta&t=jPx0rL5gxZbN7V4Nc_BHn0J5Ojb0axc_IZWZRYvthaE",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/44/1711895892489?e=1712793600&v=beta&t=MKjF8V51mdxjc2RtI2Y6SQ99phDgmwsLrSwRuRbx_mk",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/45/1711895892489?e=1712793600&v=beta&t=gsgKb_5B8rznZ8356NMpgv9RdL9Jp0mzFcJPTCZ5e00",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/46/1711895892489?e=1712793600&v=beta&t=m66ogH1wWO4PZZmHNrz6ZN6njWohohzhKjB-xKnK7hM",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/47/1711895892489?e=1712793600&v=beta&t=pydEVfN6H3EcXEfz3uMjGUbGxjKgAHDPrXkFFzzsl5I",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/48/1711895892489?e=1712793600&v=beta&t=9MkNWqRuyBkiXgEfKAl4B_XQtRoec4hFzhuZxK7uZ2Y",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/49/1711895892489?e=1712793600&v=beta&t=DQXx80Z2chsmKcOCrFZA87PtJcPl_ZHTeDC-QkIbX1U",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/50/1711895892489?e=1712793600&v=beta&t=geq9Jk6-SDIlDHTrbRWkddqZPSloxAc_B9nsdPNyI4A",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/51/1711895892489?e=1712793600&v=beta&t=sIcRDfXUNKwF803hnl75d_18mWPWIFkO14-NpwRlTxE",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/52/1711895892489?e=1712793600&v=beta&t=TOSJG8qgnI5B_r33QgrzVzo2vNOEdfGZkL3uWg1WZN8",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/53/1711895892489?e=1712793600&v=beta&t=16ruvGiU6SOf1LgM_1s0fMNY3mKfIwNC4zx0U8htyu4",
                "https://media.licdn.com/dms/image/D561FAQH840lbv899Rw/feedshare-document-images_1280/54/1711895892489?e=1712793600&v=beta&t=LJu2yeh7PpgMVK36GZwulHbi0o_qvGxS1ObJh8s95AM"
    };

        for (int i = 0; i < arr.length; i++) {

            InputStream in = new URL(arr[i]).openStream();
            Files.copy(in, Paths.get(String.format("/Applications/codebase/spring-boot-projects/continous-preparation/src/main/resources/reactFiles/reactBasics-%d.png", i)), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
