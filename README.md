# ChallengeDailyUI
100天每天挑戰UI設計<br /><br /><br />
## Day 10  Social Share

[★ 專案Android Studio](https://github.com/tzutzu858/010Social-Share)<br /><br />
分享APP訊息到其他APP的方式有兩種<br />
一種是使用開放平台的API,每一個APP去實作,例如FB分享[FB官方文件說明](https://developers.facebook.com/docs/sharing/android/?sdk=maven)<br />
這種比較麻煩,跟寫FB登入一樣,需要金鑰,Fb應用程式編號等等<br />
寫完程式不能放在公開github,要不然像我一樣被關掉,因為API密鑰不能被洩漏T_T<br />
優點是功能比較多,分享內容、照片、影片、對話方塊等等,但每一個分享平台就要寫一次真的還挺麻煩<br />
<br />
另一種Social Share寫法不到20行就寫完了<br />
App指定接收某些意圖，讓App收到這個意圖，如果有多個App都指定接收這個意圖時，<br />
Android就會將這些App列出清單，使用者可以自行選擇要用哪一種APP分享<br />
如果讓Android列出的APP清單不要某些特定APP,可以參考[這篇](https://stackoverflow.com/questions/9730243/how-to-filter-specific-apps-for-action-send-intent-and-set-a-different-text-for)<br /><br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/10_Social%20Share/010social_share-01.png" width="700" >
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/10_Social%20Share/20200116_223636.gif" width="250" >


<br /><br /><br />
## Day 9  Music Player
VideoView SeekBar 自定義View(音頻條)<br />
有bug待修<br />
[★ 專案Android Studio](https://github.com/tzutzu858/009Music-Player)
<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/09_Music%20Player/mediaPlayer.gif" width="300" >
<br /><br /><br />
## Day 8  404 Page

想不到404要什麼主題,只好再度請出威爾森了<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/08_404%20Page/008_404-01.png" width="700" >
<br /><br /><br />
## Day 7  Settings

XD開關動畫要使用到組合組件,去畫兩個狀態用動畫連接,prototype裡去新增interaction<br />
預覽時,文字沒有產生動畫,以及拖曳的動畫之後再研究<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/07_Settings/007settings.gif" width="700" >
<br /><br /><br />
## Day 6  User Profile

第一次嘗試使用XD來做頁面轉換動畫以及圓形滑動選單<br />
恩...也是花了不少時間,可能不熟吧<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/06_User%20Profile/006User-Profile.gif" width="700" >
<br /><br /><br />
## Day 5  App Icon

設計之前手機程式班結訓作品的icon<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/05_App%20Icon/005icon.JPG" width="600" >
<br /><br /><br />
## Day 4  Calculator

覺得計算機不需要太多花俏設計,因此直接練習實作一個APP<br />
練習TableLayout兩個重點<br />
1.stretchColumns="*" 表示所有列都要自動拉伸<br />
2.layout_span=" " 指定該單元佔據的列数<br /><br />
[★ 老師放在Eclipse的範例](https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/04_Calculator/Calculator.java)
<br />
[★ 專案Android Studio](https://github.com/tzutzu858/004Calculator)
<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/04_Calculator/Calculator.gif" width="300" >
<br /><br /><br />
## Day 3  Landing Page

繼續用Day2的那隻狗狗當素材<br />
硬體設備不夠,Photoshop跑gif很吃重,是時候要趕快熟悉輕量級的XD來做介面設計了<br />
構思和執行依然花太多時間<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/03_Landing%20page/003.gif" width="600" >
<br /><br /><br />
## Day 2  Credit Card Checkout

直接沿用pet home當主題作為一個捐款的Credit Card Checkout設計<br />
結果兩個頁面風格搭不起來<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/02_Credit%20Card%20Checkout/002_checkout.png" width="800" >
<br /><br /><br />
## Day 1  Sign up

原本想做一個插畫風格,結果改圖改超久,網路大家都說醜沒關係,因為每天都有題目,無法慢慢做<br />
但剛開始有點放不下,希望後面速度可以越來越快<br />
<img src="https://github.com/tzutzu858/ChallengeDailyUI/blob/master/Day01_10/01_signup/001_sign%20up.png" width="800" >

