<%-- 
    Document   : CreateAnAccount
    Created on : 2023年4月21日, 上午02:33:30
    Author     : qwer1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js'></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="">
            <jsp:include page="heading.jsp" />
        </div>

        <div class="row d-flex justify-content-center" style="margin-top:200px;">
            <div class="col-md-7">
                <div class="card px-5 py-4" id="form1">
                    <div class="form-data" v-if="!submitted">

                        <form method="get" action="CustomerAdd">
                            <input type="hidden" name="action" value="add"/>
                            <div class="text-center mb-4">
                                <h4>Register Now</h4>
                            </div>
                            <div class="forms-inputs mb-4"> <span>Email</span> 
                                <input type="text" name="email">
                                <div class="invalid-feedback">A valid email is required!</div>
                            </div>
                            <div class="forms-inputs mb-4"> <span>Username</span> 
                                <input type="text"  name="username">
                                <div class="invalid-feedback">A valid username is required!</div>
                            </div>
                            <div class="forms-inputs mb-4"> <span>Phone</span> 
                                <input type="text" name="phone" >
                                <div class="invalid-feedback">A valid phone is required!</div>
                            </div>
                            <div class="forms-inputs mb-4"> <span>Password</span> 
                                <input type="password" name="password" >
                                <div class="invalid-feedback">Password must be 8 character!</div>
                            </div>
                            <div class="forms-inputs mb-4"> <span>age</span> 
                                <input type="number" name="age"  >
                                <div class="invalid-feedback">A valid username is required!</div>
                            </div>

                            <div class="mb-3"> <input type="submit" class="btn btn-dark w-100"> </div>
                        </form>
                    </div>
                    <div class="success-data" v-else>
                        <div class="text-center d-flex flex-column"> <i class='bx bxs-badge-check'></i> <span class="text-center fs-3">Your has been created <br> Successfully</span> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
    <script type='text/javascript' src='#'></script>
    <script type='text/javascript' src='#'></script>
    <script type='text/javascript' src='#'></script>
    <script type='text/javascript'>var app = new Vue({
            el: '#form1',
            data: function () {
                return {
                    email: "",
                    emailBlured: false,
                    valid: false,
                    submitted: false,
                    password: "",
                    passwordBlured: false,
                    username: "",
                    usernameBlured: false,
                    phone: "",
                    phoneBlured: false
                }
            },

            methods: {

                validate: function () {
                    this.emailBlured = true;
                    this.passwordBlured = true;
                    this.usernameBlured = true;
                    this.phoneBlured = true;
                    if (this.validEmail(this.email) && this.validPassword(this.password) && this.validPhone(this.phone) && this.validUsername(this.username)) {
                        this.valid = true;
                    }
                },

                validEmail: function (email) {
                    var re = /(.+)@(.+){2,}\.(.+){2,}/;
                    if (re.test(email.toLowerCase())) {
                        return true;
                    }
                },

                validPassword: function (password) {
                    if (password.length > 7) {
                        return true;
                    }
                },

                validUsername: function (username) {

                    if (!/\s/.test(username)) {
                        return true;
                    }
                },

                validPhone: function (phone) {
                    if (phone.length > 9 && phone.length < 12) {
                        return true;
                    }
                },

                submit: function () {
                    this.validate();
                    if (this.valid) {
                        this.submitted = true;
                    }
                }
            }
        });</script>
    <script type='text/javascript'>var myLink = document.querySelector('a[href="#"]');
        myLink.addEventListener('click', function (e) {
            e.preventDefault();
        });</script>

</body>
</html>


<!-- <div class="forms-inputs mb-4"> <span>Email</span> 
                        <input type="text" name="email" v-model="email" v-bind:class="{'form-control':true, 'is-invalid' : !validEmail(email) && emailBlured}" v-on:blur="emailBlured = true">
                        <div class="invalid-feedback">A valid email is required!</div>
                    </div>
                    <div class="forms-inputs mb-4"> <span>Username</span> 
                        <input type="text"  name="username" v-model="username" v-bind:class="{'form-control':true, 'is-invalid' : !validUsername(username) && usernameBlured}" v-on:blur="usernameBlured = true">
                        <div class="invalid-feedback">A valid username is required!</div>
                    </div>
                    <div class="forms-inputs mb-4"> <span>Phone</span> 
                        <input type="text" name="phone" v-model="phone" v-bind:class="{'form-control':true, 'is-invalid' : !validPhone(phone) && phoneBlured}" v-on:blur="phoneBlured = true">
                        <div class="invalid-feedback">A valid phone is required!</div>
                    </div>
                    <div class="forms-inputs mb-4"> <span>Password</span> 
                        <input type="password" name="password" v-model="password" v-bind:class="{'form-control':true, 'is-invalid' : !validPassword(password) && passwordBlured}" v-on:blur="passwordBlured = true">
                        <div class="invalid-feedback">Password must be 8 character!</div>
                    </div>
                    
                    <div class="forms-inputs mb-4"> <span>age</span> 
                        <input type="number" name="age"  v-bind:class="{'form-control':true, 'is-invalid' : !validUsername(username) && usernameBlured}" v-on:blur="usernameBlured = true">
                        <div class="invalid-feedback">A valid username is required!</div>
                    </div>-->