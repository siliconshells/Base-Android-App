package com.pixelresolve.pixa.sharedmodels;

public class PixaUser {

        private Long userid;

        private String username;

        private String realname;

        private String password;


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public void setUserid(Long userid) {
            this.userid = userid;
        }

        public Long getUserid() {
            return userid;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

}
