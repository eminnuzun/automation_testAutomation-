# automation_testAutomation

Bu proje, [https://www.automationexercise.com/](https://www.automationexercise.com/) sitesinde test senaryolarını otomasyonla gerçekleştirmek için hazırlanmıştır.  
Teknolojiler: **Selenium WebDriver**, **Cucumber**, **TestNG**, **Maven**, **Page Object Model (POM)**.

---

## 📁 Proje Yapısı

```
/src
  /main
    /java
      /pages      -> Page Object sınıfları
      /utils      -> Driver ayarı, yardımcı metotlar
  /test
    /java
      /stepdefs   -> Cucumber Step Definitions
  /features
    .feature      -> Gherkin senaryoları
pom.xml
README.md
```

---

## ⚙️ Gereksinimler

- Java 8+
- Maven
- IDE (IntelliJ IDEA)
- Chrome WebDriver

---

## 🔧 Kurulum

1. Bu projeyi GitHub'dan klonlayın:

   ```bash
   git clone https://github.com/eminnuzun/automation_testAutomation-.git
   cd automation_testAutomation
   ```

2. Gerekli bağımlılıkları yüklemek için Maven kullanın:

   ```bash
   mvn clean install
   ```

---

## 🚀 Testleri Çalıştırma

### 1. **IDE Üzerinden**

- `TestRunner.java` dosyasını açın (`src/test/java/runners/` içinde yer almalı)
- Sağ tıklayıp "Run" ile testi başlatın

### 2. **Komut Satırı Üzerinden**

```bash
mvn test
```

---

## 🧪 Test Kapsamı

- Kullanıcı kaydı oluşturma
- Sisteme giriş yapma
- Sepete ürün ekleme ve siparişi tamamlama
- “Order Placed!” mesajı sonrası “Download Invoice” tıklanarak `invoice.txt` dosyasının indirildiğini doğrulama

---

## 🧰 Kullanılan Teknolojiler

- Selenium WebDriver
- Cucumber (Gherkin dili ile senaryolar)
- TestNG
- Maven (proje yapılandırması)
- Page Object Model (sayfa bazlı test yapısı)

---

## ✍️ Notlar

- Gerçek kullanıcı bilgisi ve kredi kartı bilgisi gerekmemektedir.
- Sahte kullanıcı bilgileri ile testler gerçekleştirilebilir.
- Örnek kullanıcı:
  - Ad: Egem Test
  - Email: egemtest@gmail.com
  - Şifre: egem12

---



## 📬 İletişim

Herhangi bir sorun veya katkı için lütfen iletişime geçebilirsiniz.
