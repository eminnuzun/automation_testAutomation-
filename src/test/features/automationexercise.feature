@automationexercise
  Feature: automationexercise test

    Scenario: Kullanıcı kaydı oluşturulması

      * "homePageCategoryTitle" elementinin görünür oldugu kontrol edilir
      * "homePageFeaturesItemsTitle" elementinin görünür oldugu kontrol edilir
      * "signup/login" elementine tıkla
      * "signupPageSignUpTitle" elementinin görünür oldugu kontrol edilir
      * "signupName" elementine "Emin uzun" textini yaz
      * "signup-email" elementine "testdeneme123@gmail.com" textini yaz
      * "signup-button" elementine tıkla
      * "signupPageEnterAccountInformationTitle" elementinin görünür oldugu kontrol edilir
      * "genderMr" elementine tıkla
      * "signupPassword" elementine "12345" textini yaz
      * "birthDay"'listesinde "1" degeri secilir
      * "birthMonths"'listesinde "June" degeri secilir
      * "birthYears"'listesinde "2001" degeri secilir
      * "newsletterCheckbox" elementine tıkla
      * "specialOffers" elementine tıkla
      * "signup-firstname" elementine "test" textini yaz
      * "signup-lastname" elementine "test" textini yaz
      * "signup-company" elementine "test" textini yaz
      * "signup-address1" elementine "test" textini yaz
      * "signup-address2" elementine "test" textini yaz
      * "signup-country"'listesinde "United States" degeri secilir
      * "signup-state" elementine "test" textini yaz
      * "signup-city" elementine "test" textini yaz
      * "signup-zipcode" elementine "test" textini yaz
      * "signup-mobile_number" elementine "test" textini yaz
      * "signup-createAccountButton" elementine tıkla
      * "signupPageAccountCreatedTitle" elementinin görünür oldugu kontrol edilir
      * "signup-continueButton" elementine tıkla
      * "homePageCategoryTitle" elementinin görünür oldugu kontrol edilir
      * "homePageFeaturesItemsTitle" elementinin görünür oldugu kontrol edilir
      * "deleteAccount" elementine tıkla
      * "signupPageAccountDeletedTitle" elementinin görünür oldugu kontrol edilir
      * "signup-continueButton" elementine tıkla
      * "2" saniye bekle

    Scenario: Ödeme işlemi yapılması

      * "invoice.txt" dosyasini sil
      * "signup/login" elementine tıkla
      * "loginPageLoginTitle" elementinin görünür oldugu kontrol edilir
      * "login-email" elementine "testdeneme1234@gmail.com" textini yaz
      * "login-password" elementine "12345" textini yaz
      * "login-button" elementine tıkla
      * "homePageCategoryTitle" elementinin görünür oldugu kontrol edilir
      * "homePageFeaturesItemsTitle" elementinin görünür oldugu kontrol edilir
      * "firstProduct" elementine tıkla
      * "productNameText" elementinin degerini "productName" keyine kaydet
      * "productPriceText" elementinin degerini "productPrice" keyine kaydet
      * "addToCartButton" elementine tıkla
      * "addedToCartTitle" elementinin görünür oldugu kontrol edilir
      * "viewCartButton" elementine tıkla
      * "firstProductNameInCart" elementinin degerinin kaydedilmis "productName" keyin degerini icerdigini kontrol et
      * "firstProductPriceInCart" elementinin degerinin kaydedilmis "productPrice" keyin degerini icerdigini kontrol et
      * "firstProductTotalPriceInCart" elementinin degerinin kaydedilmis "productPrice" keyin degerini icerdigini kontrol et
      * "proceedToCheckoutButton" elementine tıkla
      * "checkoutTitle" elementinin görünür oldugu kontrol edilir
      * "checkoutTotalAmount" elementinin degerinin kaydedilmis "productPrice" keyin degerini icerdigini kontrol et
      * "placeOrderButton" elementine tıkla
      * "paymentTitle" elementinin görünür oldugu kontrol edilir
      * "paymentNameOnCard" elementine "test" textini yaz
      * "paymentCardNumber" elementine "test" textini yaz
      * "paymentCvc" elementine "test" textini yaz
      * "paymentExpiryMonth" elementine "test" textini yaz
      * "paymentExpiryYear" elementine "test" textini yaz
      * "paymentPayAndConfirmOrderButton" elementine tıkla
      * "paymentOrderPlacedTitle" elementinin görünür oldugu kontrol edilir
      * "downloadInvoiceButton" elementine tıkla
      * "5" saniye bekle
      * "invoice.txt" dosyasinin indigini kontrol et
