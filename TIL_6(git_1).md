### Day 6 (4/11 Mon)

#### git

---

![스크린샷(469)](TIL_6(git_1).assets/스크린샷(469).png)

* Interface

  음식점의 KIOSK 같은 역할 

1. CLI(Command Line Interface) :  터미널을 통해 사용자와 컴퓨터가 상호작용하는 방식
2. GUI(Graphic User Interface) : 그래픽을 통해 사용자와 컴퓨터가 상호작용하는 방식



* 명령어

  1. touch : 파일 생성

     ex. touch a.txt / touch README.md

  2. mkdir : 폴더 생성

     ex. mkdir folder / mkdir a

     1. ls(List Segment) : 디렉토리 내의 파일을 보여주는 명령어

        ex. ls -a(모든 파일 열거)

  3. mv : 폴더/파일을 다른 폴더 내로 이동 하거나 이름을 변경하는 명령어

  4. cd(Change Directory) : 현재 작업중인 디렉토리를 변경하는 명령어

     ```
     # 현재 작업 중인 디렉토리에 있는 folder 폴더로 이동
     $ cd folder
     
     # 절대 경로를 통한 디렉토리 변경
     $ cd C:/Users/kyle/Desktop
     
     # 상대 경로를 통한 디렉토리 변경
     $ cd ../parent/child
     ```



#### git 초기설정

---

최초 한번만 설정.

1. 이름과 이메일 설정
```
$ git config --global user.name "이름"
$ git config --global user.email "메일 주소"
```
2. 작성자가 올바르게 설정되었는지 확인

```
$ git config --global -l

또는

$ git config --global --list
```



#### git 기본 명령어

---

1. git init

   * 현재 작업 중인 디렉토리를 Git으로 관리한다는 명령어
   * `.git` 이라는 숨김 폴더를 생성하고, 터미널에는 `(master)` 라고 표기됩니다.

   ```
   $ git init
   Initialized empty Git repository in C:/Users/kyle/git-practice/.git/
   
   kyle@KYLE MINGW64 ~/git-practice (master)
   ```

2. git status

   ```
   $ git status
   On branch master
   
   No commits yet
   
   nothing to commit (create/copy files and use "git add" to track)
   ```

   * Working Directory와 Staging Area에 있는 파일의 현재 상태를 알려주는 명령어

   * 상태

     1. `Unracked` : Git이 관리하지 않는 파일(Staging Area에 올라간 적 없는 파일)

     2. `Tracked` : Git이 관리하는 파일

        a. `Unmodified` : 최신 상태

        b. `Modified` : 수정되었지만 아직 Staging Area에는 반영하지 않은 상태

        c. `Staged` : Staginf Area에 올라간 상태

3. git add

   ```
   # 특정 파일
   $ git add a.txt
   
   # 특정 폴더
   $ git add my_folder/
   
   # 현재 디렉토리에 속한 파일/폴더 전부
   $ git add .
   ```

   * Working Directory에 있는 파일을 Staging Area로 올리는 명령어
   * Git이 해당 파일을 추적(관리)할 수 있도록 만듭니다.
   * `Untracked, Modified -> Staged` 로 상태를 변경합니다.

4. git commit

   ```
   $ git commit -m "first commit"
   [master (root-commit) c02659f] first commit
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 a.txt
   ```

   * Staging Area에 올라온 파일의 변경 사항을 하나의 버전(커밋)으로 저장하는 명령어

   * `커밋 메세지` 는 현재 변경 사항들을 잘 나타낼 수 있도록 의미있게 작성하는 것을 권장합니다.

   * 각각의 커밋은 SHA-1 알고리즘에 의해 반환된 고유의 해시값을 ID로 가진다.

   * `(root-commit)` 은 해당 커밋이 최초의 커밋일 때만 표시된다.

     ※ git commit 입력시 탈출 방법(메세지를 입력하지 않아서 생긴 과정):

     1. 'i'를 눌러서 insert mode로 전환
     2. 원하는 메세지 입력
     3. ESC 누르고 :wq 누르고 엔터
     
     ※ commit 메세지만 수정하기
     
     1. git commit --amend
     2. 'i' 눌러서 insert mode로 바꾸기
     3. 원하는 메세지로 변경
     4. ESC 누르고 :wq로 탈출
     
     수정 후 커밋하게 되면 새로운 해시값을 가지고 commit한다.

5. git log

   ```
   $ git log
   commit 1870222981b4731d14ef91d401c68c0bbb2f6e7d (HEAD -> master)
   Author: kyle <kyle123@hphk.kr>
   Date:   Thu Dec 9 15:26:46 2021 +0900
   
       first commit
   ```

   * 커밋의 내역(ID, 작성자, 시간, 메세지 등)을 조회할 수 있는 명령어
   * 옵션
     * `--oneline` : 한줄로 축약해서 보여준다.
     * `--graph` : branch와 merge 내역을 그래프로 보여준다.
     * `--all` : 현재 브랜치를 포함한 모든 브랜치의 내역을 보여준다.
     * `--reverse` : 커밋 내역의 순서를 반대로 보여준다.
   
6. git checkout

   * `git checkout ######(해시값)` : 과거 버전으로 일시적으로 돌아감
   * `git checkout master` : 현재 버전으로 돌아옴

※ Github Repository와 Local Repository 주소 잇기

1. `git remote add origin 주소` 
2. `git remote - v`  : 잘 이어졌는지 확인
