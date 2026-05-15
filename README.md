# 🎭 ನಮ್ಮ ಮೇಳ (Namma Mela) - Android App

## Project 13: Android App Development using GenAI - Namma-Mela (National Pride)

A **Drama Company Digital Box-Office** app for rural village theater. Built with Java, Room DB, and Glide.

---

## 📱 Screens

| Screen | Description |
|--------|-------------|
| **Splash** | Theatrical intro with app branding |
| **Home (MainActivity)** | Tonight's play poster, name, duration, venue |
| **Cast (CastActivity)** | Lead Actor, Comedian, Singer with photos |
| **Seat Map (SeatMapActivity)** | 30-seat grid, book by name, persists with Room DB |
| **Fan Wall (FanWallActivity)** | Leave applause/comments, stored in Room DB |
| **Manager Panel (ManagerActivity)** | Update play name, venue, date, poster URL |

---

## 🛠 Tech Stack

- **Language:** Java
- **Min SDK:** 24 (Android 7.0)
- **Database:** Room DB (local, no internet needed for booking)
- **Images:** Glide
- **UI:** Material Components, CardView, GridLayout, RecyclerView
- **Theme:** Theatrical dark red + gold

---

## 🚀 How to Open in Android Studio

1. Open **Android Studio** (Hedgehog or newer)
2. Click **File → Open**
3. Select the `NammaMela` folder
4. Wait for Gradle sync to complete
5. Click **Run ▶** on an emulator or connected phone

---

## 🎯 Features Implemented

- ✅ Tonight's Play screen (poster, name, duration, venue, time)
- ✅ Cast list with actor photos loaded via Glide
- ✅ Seat Map with 6-column grid layout (30 seats)
- ✅ Seat booking with name input — persists via Room DB
- ✅ Available seat count updates live
- ✅ Fan Wall — leave applause comments, stored in Room DB
- ✅ Manager Panel — update play details via SharedPreferences
- ✅ Theatrical UI — deep red + gold color theme
- ✅ All labels in Kannada language

---

## 📁 Project Structure

```
app/src/main/
├── java/com/nammamela/
│   ├── ui/
│   │   ├── SplashActivity.java
│   │   ├── MainActivity.java
│   │   ├── CastActivity.java
│   │   ├── SeatMapActivity.java
│   │   ├── FanWallActivity.java
│   │   └── ManagerActivity.java
│   ├── data/
│   │   ├── db/
│   │   │   ├── AppDatabase.java
│   │   │   ├── SeatDao.java
│   │   │   └── FanCommentDao.java
│   │   └── model/
│   │       ├── Seat.java
│   │       └── FanComment.java
│   └── adapter/
│       ├── SeatAdapter.java
│       └── FanCommentAdapter.java
└── res/
    ├── layout/  (6 activity layouts + item layouts)
    ├── values/  (colors, strings, themes)
    └── drawable/ (seat backgrounds, launcher)
```

---

## 💡 How to Customize

- **Change seat count:** Edit `TOTAL_SEATS = 30` in `SeatMapActivity.java`
- **Change cast names:** Edit `CastActivity.java`
- **Change default play:** Use the Manager Panel inside the app
- **Add poster:** Paste any image URL in Manager Panel → Poster URL

---

*Built for internship project submission — Namma Mela Digital Box Office 🎭*
