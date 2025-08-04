# 🛡️ InsuraFlow - Mikroservis Tabanlı Sağlık Sigortası Uygulaması

**InsuraFlow**, Java Spring Boot kullanılarak geliştirilen, mikroservis mimarisine uygun bir sağlık sigortası teklif ve poliçe yönetimi sistemidir. Kullanıcıdan alınan bilgiler doğrultusunda teklif oluşturulur ve bu teklif üzerinden poliçe üretimi sağlanır. Mikroservisler arası iletişim Kafka ile sağlanmaktadır.

---

## 🚀 Kullanılan Teknolojiler

<div align="left">

![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?logo=springboot)
![Kafka](https://img.shields.io/badge/Apache%20Kafka-3.9.1-black?logo=apachekafka)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue?logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?logo=docker)
![Maven](https://img.shields.io/badge/Maven-3.9.5-C71A36?logo=apachemaven)
![Lombok](https://img.shields.io/badge/Lombok-Enabled-orange?logo=lombok)
![MapStruct](https://img.shields.io/badge/MapStruct-1.5.5.Final-lightgrey)
![JPA](https://img.shields.io/badge/JPA-Hibernate-red?logo=hibernate)

</div>

---

## 🧩 Proje Mimarisi

```text
com.insuraflow
├── quoteservice          # Teklif oluşturma servisi
│   ├── controller
│   ├── service
│   ├── model
│   ├── repository
│   ├── dto
│   ├── kafka
│   └── mapper
│
├── policyservice         # Poliçe oluşturma servisi
│   ├── controller
│   ├── service
│   ├── model
│   ├── repository
│   ├── dto
│   ├── kafka
│   └── mapper
│
└── docker-compose.yml    # Kafka + Zookeeper + Kafdrop ortamı
```

## 🔄 Mikroservis İletişimi

- `quoteservice`, bir teklif başarıyla oluşturulduğunda `Kafka` üzerinden `quote-created` isimli topic'e mesaj gönderir.
- `policyservice`, bu mesajı dinleyerek otomatik olarak poliçe oluşturabilir veya işlemleri tetikleyebilir.

---

## 🗃️ Veritabanı

- Her mikroservisin kendi `PostgreSQL` veritabanı bulunur.
- Entity'ler `JPA` ile yönetilir.

---

## ▶️ Projeyi Başlatma

### 1. Kafka Ortamını Başlat

```bash
docker-compose up -d
```
### 2. Mikroservisleri Başlat
```bash

# quoteservice
cd quoteservice
mvn spring-boot:run

# policyservice
cd policyservice
mvn spring-boot:run 
```
### 3. Postman veya Kafdrop ile test et
```bash
http://localhost:8080/api/quotes (Teklif servisi)

http://localhost:8081/api/policies (Poliçe servisi)

http://localhost:9000 (Kafdrop arayüzü)
```
```json
{
  "fullName": "Erdem Kurt",
  "identityNumber": "12345678901",
  "birthDate": "1995-07-29",
  "gender": "MALE",
  "phoneNumber": "05551234567",
  "email": "erdem@example.com"
}
```
### 4. Kafdrop ile Topic takibi

![kafka1](https://github.com/user-attachments/assets/bfd455d5-e96b-4ebe-9c15-7c185a95dd30)



🤝 Katkıda Bulun
Bu proje geliştirilmeye açıktır. Issue ya da Pull Request gönderebilirsiniz.
