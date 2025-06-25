-- cshare SQL

--先生登録データ
CREATE TABLE Tidpw (
  className INT PRIMARY KEY CHECK (className BETWEEN 10 AND 40),
  tName VARCHAR(20) NOT NULL,
  tPw VARCHAR(20) NOT NULL
);

INSERT INTO Tidpw (className, tName, tPw)
VALUES (11, 'dojouser1', '#SEplus2025SEplus'),
       (12, 'dojouser2', '#SEplus2025SEplus');



--生徒登録データ
CREATE TABLE Sidpw (
  className INT CHECK (className BETWEEN 10 AND 40) NOT NULL,
  sName VARCHAR(20) NOT NULL,
  number INT PRIMARY KEY CHECK (number BETWEEN 100000 AND 999999),
  sPw VARCHAR(20) NOT NULL,
  FOREIGN KEY (className) REFERENCES Tidpw(className) ON DELETE CASCADE
);

INSERT INTO Sidpw (className, sName, number, sPw)
VALUES
  (11, '今井幸助', 251106, '#SEplus2025SEplus'),
  (11, '佐藤一', 251107, '#SEplus2025SEplus'),
  (11, '井上香', 251104, '#SEplus2025SEplus'),
  (11, '白石勝吾', 251113, '#SEplus2025SEplus'),
  (12, '伊藤麻里', 251204, '#SEplus2025SEplus'),
  (12, '斎藤亮', 251208, '#SEplus2025SEplus');


--保護者登録データ
CREATE TABLE Pidpw (
  pName VARCHAR(20) NOT NULL,
  number INT NOT NULL,
  pPw VARCHAR(20) NOT NULL,
  PRIMARY KEY (number),
  CHECK (number BETWEEN 100000 AND 999999),
  FOREIGN KEY (number) REFERENCES Sidpw(number) ON DELETE CASCADE
);

INSERT INTO Pidpw (pName, number, pPw)
VALUES
  ('今井昭子', 251106, '#SEplus2025SEplus'),
  ('佐藤裕香', 251107, '#SEplus2025SEplus'),
  ('井上恵美', 251104, '#SEplus2025SEplus'),
  ('白石康太', 251113, '#SEplus2025SEplus'),
  ('伊藤順子', 251204, '#SEplus2025SEplus'),
  ('斎藤雄太', 251208, '#SEplus2025SEplus');


--出席情報
CREATE TABLE Attendance (
  attendantId INT AUTO_INCREMENT PRIMARY KEY,
  number INT CHECK (number BETWEEN 100000 AND 999999),
  status ENUM ('出席', '欠席', '遅刻', '早退') NOT NULL,
  attendanceDate DATE NOT NULL,
  FOREIGN KEY (number) REFERENCES Sidpw(number) ON DELETE CASCADE
);

--成績管理
CREATE TABLE Tests (
  testsId INT AUTO_INCREMENT PRIMARY KEY,
  number INT NOT NULL,
  term INT NOT NULL,
  testName VARCHAR(20) NOT NULL,
  japanese INT,
  averageJapanese INT,
  math INT,
  averageMath INT,
  science INT,
  averageScience INT,
  social INT,
  averageSocial INT,
  english INT,
  averageEnglish INT,
  sum INT,
  averageSum INT,
  FOREIGN KEY (number) REFERENCES Sidpw(number) ON DELETE CASCADE,
  CHECK (number BETWEEN 100000 AND 999999),
  CHECK (term BETWEEN 0 AND 9),
  CHECK (japanese BETWEEN 0 AND 100),
  CHECK (averageJapanese BETWEEN 0 AND 100),
  CHECK (math BETWEEN 0 AND 100),
  CHECK (averageMath BETWEEN 0 AND 100),
  CHECK (science BETWEEN 0 AND 100),
  CHECK (averageScience BETWEEN 0 AND 100),
  CHECK (social BETWEEN 0 AND 100),
  CHECK (averageSocial BETWEEN 0 AND 100),
  CHECK (english BETWEEN 0 AND 100),
  CHECK (averageEnglish BETWEEN 0 AND 100),
  CHECK (sum BETWEEN 0 AND 500),
  CHECK (averageSum BETWEEN 0 AND 500)
);

INSERT INTO Tests (
  number, term, testName,
  japanese, averageJapanese,
  math, averageMath,
  science, averageScience,
  social, averageSocial,
  english, averageEnglish,
  sum, averageSum
)
VALUES
  (251106, 1, '中間', 78, 70, 82, 75, 80, 72, 76, 69, 84, 73, 400, 359),
  (251107, 1, '中間', 65, 70, 70, 75, 72, 72, 68, 69, 74, 73, 349, 359);


--連絡管理
CREATE TABLE Announcements (
  announceId INT AUTO_INCREMENT PRIMARY KEY,
  className INT NOT NULL,
  announce TEXT NOT NULL,
  announceDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CHECK (className BETWEEN 10 AND 40),
  FOREIGN KEY (className) REFERENCES Tidpw(className) ON DELETE CASCADE
);