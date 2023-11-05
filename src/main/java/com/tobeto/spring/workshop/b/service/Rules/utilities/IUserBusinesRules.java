package com.tobeto.spring.workshop.b.service.Rules.utilities;

public interface IUserBusinesRules {

   void ifCheckUserId(int identity);

   void ifCheckUserName(String userName);
   void ifCheckUserEmail(String userEmail);

   void ifCheckDeleteUser(int identity);

}
