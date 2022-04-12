### Day 7 (4/12 Tue)

#### git

---

<h5>* git clone</h5>

* 원격 저장소의 커밋 내역을 모두 가져와서, 로컬 저장소를 생성하는 명령어

* `git clone` 명령어를 사용하면 원격 저장소를 통째로 복제해서 내 컴퓨터에 옮길 수 있습니다.

  ```
  $ git clone https://github.com/edukyle/TIL.git
  Cloning into 'TIL'...
  remote: Enumerating objects: 3, done.
  remote: Counting objects: 100% (3/3), done.
  remote: Total 3 (delta 0), reused 3 (delta 0), pack-reused 0
  Receiving objects: 100% (3/3), done.
  ```

  위의 코드를 실행하면, TIL이라는 원격 저장소를 복제하여 내 컴퓨터에 TIL이라는 이름의 로컬 저장소를 생성하게 된다.

* git clone 명령어를 실행하면 `git init` 과 `git remote add` 명령어가 모두 적용된다.



<h5>*git pull</h5>

* 원격 저장소의 변경 사항을 가져와서, 로컬 저장소를 업데이트하는 명령어

* `git pull <저장소 이름> <브랜치 이름>` 의 형태로 작성합니다.

  ```
  $ git pull origin master
  From https://github.com/edukyle/git-practice
   * branch            master     -> FETCH_HEAD
  Updating 6570ecb..56809a9
  Fast-forward
   README.md | 1 +
   1 file changed, 1 insertion(+)
  
  
  [풀이]
  git 명령어를 사용할건데, origin이라는 원격 저장소의 master 브랜치의 내용을 가져온다(pull).
  ```

  

<h6>※ git clone vs git pull</h6>

clone과 pull이 모두 원격 저장소로부터 가져오는 명령어라서 조금 혼동될 수 있습니다.  git clone은 git init처럼 처음에 한 번만 실행합니다. 즉 로컬 저장소를 만드는 역할이죠.<br>

 단, git init처럼 직접 로컬 저장소를 만드는 게 아니라, Github에서 저장소를 복제해서 내 컴퓨터에 똑같은 복제본을 만든다는 차이가 있습니다. <br>

 git pull은 git push처럼 로컬 저장소와 원격 저장소의 내용을 동기화하고 싶다면 언제든 사용합니다. 단, push는 로컬 저장소의 변경 내용을 원격 저장소에 반영하는 것이고, pull은 원격 저장소의 변경 내용을 로컬 저장소에 반영하는 것입니다. 즉 방향이 다릅니다!





#### branch

---

(1) Branch란?

![img](https://hphk.notion.site/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fd6378065-5864-4832-8122-0fde3eb4f6ec%2FUntitled.png?table=block&id=aa9b0e1b-bb8b-48ff-85e2-4889a1286ad3&spaceId=daa2d103-3ecd-4519-8c30-4f55e74c7ef4&width=1530&userId=&cache=v2)

* 브랜치란 나뭇가지처럼 여러 갈래로 작업 공간을 나누어 독립적으로 작업할 수 있도록 도와주는 Git의 도구입니다.
* `장점` 
  1. 브랜치는 독립 공간을 형성하기 때문에 원본(master)에 대해 안전합니다.
  2. 하나의 작업은 하나의 브랜치로 나누어 진행되므로 체계적인 개발이 가능합니다.
  3. 특히나 Git은 브랜치를 만드는 속도가 굉장히 빠르고, 용량도 적게 듭니다.
* `그래도 브랜치 꼭 써야하나요?`
  1. 일단 master 브랜치는 상용을 의미합니다. 그래서 언제든 세상에 공개되어 있습니다.
  2. 만약 상용에 에러가 있어서 고쳐야 한다면 어떻게 해야할까요?
  3. 고객들이 사용하고 있는데, 함부로 버전을 되돌리거나 삭제할 수 있을까요?
  4. 따라서 브랜치를 통해 별도의 작업 공간을 만들고, 그곳에서 되돌리거나 삭제를 합니다.
  5. 브랜치는 완전하게 독립이 되어있어서 어떤 작업을 해도 master에는 영향을 끼치지 못하죠.
  6. 그리고 이후에 에러를 해결했다면? 그 내용을 master에 반영할 수도 있습니다!
  7. 이러한 이유 때문에 Git에서 브랜치는 정말 강력한 기능 중의 하나라고 할 수 있습니다.

(2) git branch

* 브랜치 `조회, 생성, 삭제 등` 브랜치와 관련된 명령어

  ```
  # 브랜치 목록 확인
  $ git branch
  
  # 원격 저장소의 브랜치 목록 확인
  $ git branch -r
  
  # 새로운 브랜치 생성
  $ git branch <브랜치 이름>
  
  # 특정 커밋 기준으로 브랜치 생성
  $ git branch <브랜치 이름> <커밋 ID>
  
  # 특정 브랜치 삭제
  $ git branch -d <브랜치 이름> # 병합된 브랜치만 삭제 가능
  $ git branch -D <브랜치 이름> # (주의) 강제 삭제 (병합되지 않은 브랜치도 삭제 가능)
  ```

(3) git switch

* 현재 브랜치에서 다른 브랜츠로 `HEAD` 를 이동시키는 명령어

  `HEAD` 란 현재 브랜치를 가리키는 포인터를 의미합니다.

  ```
  # 다른 브랜치로 이동
  $ git switch <다른 브랜치 이름>
  
  # 브랜치를 새로 생성과 동시에 이동
  $ git switch -c <브랜치 이름>
  
  # 특정 커밋 기준으로 브랜치 생성과 동시에 이동
  $ git switch -c <브랜치 이름> <커밋 ID>
  ```



#### branch Scenario

---

### (1) 사전 세팅

1. 홈 디렉토리에 `git-branch-practice` 폴더를 생성하고 이동 후 vscode를 엽니다.

   ```bash
   $ mkdir git-branch-practice
   $ cd git-branch-practice
   $ code .
   ```

2. Git 저장소를 생성합니다.

   ```bash
   $ git init
   Initialized empty Git repository in C:/Users/kyle/git-branch-practice/.git/
   ```

3. `test.txt`를 생성하고 각각 `master-1, master-2, master-3` 이라는 내용을 순서대로 입력하여 커밋 3개를 작성합니다.

   ```bash
   $ touch test.txt
   
   test.txt에 master-1 작성
   $ git add .
   $ git commit -m "master-1"
   
   test.txt에 master-2 작성
   $ git add .
   $ git commit -m "master-2"
   
   test.txt에 master-3 작성
   $ git add .
   $ git commit -m "master-3"
   ```

4. `git log --oneline`을 입력했을 때 아래와 같이 나와야 정상입니다.

   총 3개의 버전이 master 브랜치에 만들어졌습니다.

   ```bash
   $ git log --oneline
   0604dcd (HEAD -> master) master-3
   9c22c89 master-2
   3d71510 master-1
   ```

5. 현재까지 결과

   ![Untitled (1)](TIL_7(git_2).assets/Untitled (1).png)

### (2) 브랜치 생성, 조회

1. 현재 위치(master 브랜치의 최신 커밋)에서 `login`이라는 이름으로 브랜치를 생성합니다.

   ```bash
   $ git branch login
   ```

2. login브랜치가 잘 생성되었는지 확인합니다.

   `* master`의 의미는 현재 HEAD가 가리키는 브랜치는 `master`라는 것입니다.

   ```bash
   $ git branch
   	login
   * master
   ```

3. `git log --oneline`을 입력했을 때 아래와 같이 나와야 정상입니다.

   `0604dcd` 커밋 기준으로 `master`와 `login`브랜치가 위치한 것을 볼 수 있습니다.

   ```bash
   $ git log --oneline
   0604dcd (HEAD -> master, login) master-3
   9c22c89 master-2
   3d71510 master-1
   ```

4. `master` 브랜치에서 1개의 커밋을 더 작성합니다.

   ```bash
   test.txt에 master-4 작성
   $ git add .
   $ git commit -m "master-4"
   ```

5. 현재까지 결과

   ![Untitled (2)](TIL_7(git_2).assets/Untitled (2).png)

### (3) 브랜치 이동

1. 현재 브랜치와 커밋의 상태는 다음과 같습니다.

   ```bash
   $ git log --oneline
   5ca7701 (HEAD -> master) master-4
   0604dcd (login) master-3
   9c22c89 master-2
   3d71510 master-1
   ```

2. 이때 `login`브랜치로 이동하면 어떤 일이 일어날까요?

   ```bash
   $ git switch login
   ```

   **master 브랜치의 test.txt에 작성한 master-4가 지워졌습니다!!**

   ```bash
   # login 브랜치의 test.txt
   
   master-1
   master-2
   master-3
   ```

3. 그리고 `git log --oneline`을 입력하면 아래와 같이 나타납니다.

   이제 `HEAD`는 `login` 브랜치를 가리키고, `master` 브랜치가 보이지 않습니다.

   ```bash
   $ git log --oneline
   0604dcd (HEAD -> login) master-3
   9c22c89 master-2
   3d71510 master-1
   ```

4. master 브랜치는 삭제된 걸까요?

   아닙니다! 브랜치를 조회 해보면 다음과 같이 나타납니다.

   HEAD가 `login` 브랜치를 가리키면서, log도 `login` 브랜치 기준으로 보이는 것이었습니다.

   ```bash
   $ git branch
   * login
     master
   ```

5. `git log --oneline --all`을 입력하면 모든 브랜치의 로그를 볼 수 있습니다.

   ```bash
   $ git log --oneline --all
   5ca7701 (master) master-4
   0604dcd (HEAD -> login) master-3
   9c22c89 master-2
   3d71510 master-1
   ```

6. 현재까지 결과

   ![Untitled (3)](TIL_7(git_2).assets/Untitled (3).png)

<aside> 💡 즉 브랜치를 이동한다는건 HEAD가 해당 브랜치를 가리킨다는 것을 의미하고 브랜치는 최신 커밋을 가리키므로, **HEAD가 해당 브랜치의 최신 커밋을 가리키게 됩니다.

따라서 워킹 디렉토리의 내용도 HEAD가 가리키는 브랜치의 최신 커밋 상태로 변화합니다.**

</aside>

### (4) login 브랜치에서 커밋 생성

1. `test.txt` 파일에 `login-1`이라고 작성합니다.

   ```bash
   # login 브랜치의 test.txt
   master-1
   master-2
   master-3
   login-1
   ```

2. 추가적으로 `test_login.txt`도 생성하고 `login-1`이라고 작성해봅시다.

   ```bash
   $ touch test_login.txt
   
   # 이후 test_login.txt에 작성
   login-1
   ```

3. 커밋을 생성합니다.

   ```bash
   $ git add .
   $ git commit -m "login-1"
   ```

4. `git log --oneline --all --graph`를 통해 아래와 같은 내용을 확인합니다.

   `master` 브랜치와 `login` 브랜치가 다른 갈래로 갈라진 것을 확인할 수 있습니다.

   ```bash
   $ git log --oneline --graph --all
   * 3b0a091 (HEAD -> login) login-1
   | * 5ca7701 (master) master-4
   |/
   * 0604dcd master-3
   * 9c22c89 master-2
   * 3d71510 master-1
   ```

5. 현재까지 결과

   ![Untitled](TIL_7(git_2).assets/Untitled.png)



#### Branch Merge

---

[1] git merge

* 분기된 브랜치들을 하나로 합치는 명령어

* `git merge <합칠 브랜치 이름>` 의 형태로 사용한다.

* <h6>Merge하기 전에 일단 다른 브랜치를 합치려고 하는, 즉 메인 브랜치로 switch 해야한다</h6>

  ```
  # 1. 현재 branch1과 branch2가 있고, HEAD가 가리키는 곳은 branch1 입니다.
  $ git branch
  * branch1
    branch2
  
  # 2. branch2를 branch1에 합치려면?
  $ git merge branch2
  
  # 3. branch1을 branch2에 합치려면?
  $ git switch branch2
  $ git merge branch1
  ```

  

[2] branch merge Scenario

### (1) 사전 세팅

```bash
$ mkdir git_merge
$ cd git_merge

$ git init
$ touch test.txt

# test.txt 에 master test 1 을 입력 후 저장

$ git add .
$ git commit -m "master test 1"
```

### (2) Fast-Forward

![111](TIL_7(git_2).assets/111.png)

<aside> 💡 **login 브랜치가 생성된 이후 master 브랜치에 변경 사항이 없는 상황**

즉, master 브랜치에서 login 브랜치를 merge 할 때 login 브랜치가 master 브랜치 이후의 커밋을 가리키고 있으면 그저 master 브랜치가 login 브랜치와 동일한 커밋을 가리키도록 이동 시킬 뿐입니다. </aside>

1. `login` 브랜치 생성 및 이동합니다.

   ```bash
   $ git switch -c login
   ```

2. `login.txt`를 만들고 커밋합니다.

   ```bash
   $ touch login.txt
   $ git add .
   $ git commit -m "login test 1"
   ```

3. `master` 브랜치로 이동합니다.

   ```bash
   $ git switch master
   
   $ git log --oneline --all --graph
   * df231d0 (login) login test 1
   * 1e62b4c (HEAD -> master) master test 1
   ```

4. `master`에 `login`을 병합합니다.

   ```bash
   $ git merge login
   Updating 1e62b4c..df231d0
   **Fast-forward**
    login.txt | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 login.txt
   ```

5. 결과를 확인합니다. (**Fast-forward**, 단순히 HEAD를 앞으로 빨리감기)

   ```bash
   $ git log --oneline --all --graph
   * df231d0 (HEAD -> master, login) login test 1
   * 1e62b4c master test 1
   ```

6. `login` 브랜치를 삭제합니다.

   ```bash
   $ git branch -d login
   Deleted branch login (was df231d0).
   
   $ git log --oneline --all --graph
   * df231d0 (HEAD -> master) login test 1
   * 1e62b4c master test 1
   ```



### (3) Merge Conflict

![merge comflict](TIL_7(git_2).assets/merge comflict.png)

<aside> 💡 Merge 하는 두 브랜치에서 **같은 파일의 한 부분을 동시에 수정**하고 Merge 하면 Git은 해당 부분을 자동으로 Merge 하지 못하고 충돌이 일어납니다. **(반면 동일 파일이더라도 서로 다른 부분을 수정했다면, Conflict 없이 자동으로 Merge Commit 됩니다!)**

</aside>

1. `hotfix` 브랜치를 생성 및 이동합니다.

   ```bash
   $ git switch -c hotfix
   ```

2. 특정 작업 완료 후 커밋합니다.

   ```bash
   # test.txt 수정
   
   master test 1
   **이건 hotfix에서 작성한 문장입니다.**
   ```

   ```bash
   $ git add .
   $ git commit -m "hotfix test 1"
   
   $ git log --oneline --graph --all
   * ad045fa (HEAD -> hotfix) hotfix test 1
   *   ac0e971 (master) Merge branch 'signout'
   |\\
   | * bcade83 signout test 1
   * | 48bd5a6 master test 2
   |/
   * df231d0 login test 1
   * 1e62b4c master test 1
   ```

3. `master` 브랜치로 이동합니다.

   ```bash
   $ git switch master
   ```

4. 특정 작업(`hotfix` 와 동일 파일의 동일 부분 수정) 완료 후 커밋합니다.

   ```bash
   # text.txt 수정
   
   master test 1
   **이건 master에서 작성한 문장입니다.**
   ```

   ```bash
   $ git add .
   $ git commit -m "master test 3"
   
   $ git log --oneline --all --graph
   * 3170247 (HEAD -> master) master test 3
   | * ad045fa (hotfix) hotfix test 1
   |/
   *   ac0e971 Merge branch 'signout'
   |\\
   | * bcade83 signout test 1
   * | 48bd5a6 master test 2
   |/
   * df231d0 login test 1
   * 1e62b4c master test 1
   ```

5. `master`에 `hotfix`를 병합합니다.

   ```bash
   $ git merge hotfix
   ```

6. 결과 → merge conflict 발생 (**같은 파일의 같은 문장을 수정했기 때문입니다!**)

   ![Untitled (4)](TIL_7(git_2).assets/Untitled (4).png)

7. 충돌 확인 및 해결

   - Merge Conflict가 일어났을 때 Git이 어떤 파일을 Merge 할 수 없었는지 살펴보려면 `git status` 명령을 이용합니다.

   ```bash
   $ git status
   On branch master
   You have unmerged paths.
     (fix conflicts and run "git commit")
     (use "git merge --abort" to abort the merge)
   
   Unmerged paths:
     (use "git add <file>..." to mark resolution)
           both modified:   test.txt
   
   no changes added to commit (use "git add" and/or "git commit -a")
   ```

   ```
   master test 1
   <<<<<<< HEAD
   이건 master에서 작성한 문장입니다.
   =======
   이건 hotfix에서 작성한 문장입니다.
   >>>>>>> hotfix
   ```

   - `=======` 위쪽의 내용은 HEAD 버전(merge 명령을 실행할 때 작업하던 `master` 브랜치)의 내용이고 아래쪽은 `hotfix` 브랜치의 내용입니다. 충돌을 해결하려면 위쪽이나 아래쪽 내용 중에서 고르거나 새로 작성하여 Merge 해야 합니다. (`<<<<<<<, =======, >>>>>>>` 가 포함된 행은 삭제)

   ```bash
   # test.txt 최종본
   
   master test 1
   이건 충돌을 해결한 후의 문장입니다.
   ```

8. merge commit 진행합니다.

   ```bash
   $ git add .
   $ git commit
   ```

   - vim 편집기 등장

     ```bash
     Merge branch 'hotfix'
     
     # Conflicts:
     #       test.txt
     #
     # It looks like you may be committing a merge.
     # If this is not correct, please run
     #       git update-ref -d MERGE_HEAD
     # and try again.
     
     # Please enter the commit message for your changes. Lines starting
     # with '#' will be ignored, and an empty message aborts the commit.
     #
     # On branch master
     # All conflicts fixed but you are still merging.
     #
     ```

   - 작성된 커밋 메세지를 확인하고 `esc` 를 누른후 `:wq` 를 입력하여 저장 & 종료합니다.

     ```bash
     $ git commit
     [master 8ef1443] Merge branch 'hotfix'
     ```

9. log 확인

   ```bash
   $ git log --oneline --all --graph
   *   8ef1443 (HEAD -> master) Merge branch 'hotfix'
   |\\
   | * ad045fa (hotfix) hotfix test 1
   * | 3170247 master test 3
   |/
   *   ac0e971 Merge branch 'signout'
   |\\
   | * bcade83 signout test 1
   * | 48bd5a6 master test 2
   |/
   * df231d0 login test 1
   * 1e62b4c master test 1
   ```

10. `hotfix` 브랜치를 삭제합니다.





#### Git workflow

---

## [1] 원격 저장소 소유권이 있는 경우 (Shared repository model)

### (1) 개념

- 원격 저장소가 자신의 소유이거나 collaborator로 등록되어 있는 경우에 가능합니다.
- master에 직접 개발하는 것이 아니라, `기능별로 브랜치`를 따로 만들어서 개발합니다.
- `Pull Request`를 같이 사용하여 팀원 간 변경 내용에 대한 소통을 진행합니다.

### (2) 작업 흐름

1. 소유권이 있는 원격 저장소를 로컬 저장소로 `clone` 받습니다.

   ![Untitled (5)](TIL_7(git_2).assets/Untitled (5).png)

   ```bash
   $ git clone <https://github.com/edukyle/django-project.git>
   ```

2. 사용자는 자신이 작업할 기능에 대한 `브랜치를 생성`하고, 그 안에서 `기능을 구현`합니다.

   ![Untitled (6)](TIL_7(git_2).assets/Untitled (6).png)

   ```bash
   $ git switch -c feature/login
   ```

3. 기능 구현이 완료되면, 원격 저장소에 해당 브랜치를 `push` 합니다.

   ![Untitled (7)](TIL_7(git_2).assets/Untitled (7).png)

   ```bash
   $ git push origin feature/login
   ```

4. 원격 저장소에는 master와 각 기능의 브랜치가 반영되었습니다.

   ![Untitled (8)](TIL_7(git_2).assets/Untitled (8).png)

5. Pull Request를 통해 브랜치를 master에 반영해달라는 요청을 보냅니다. (팀원들과 코드 리뷰를 통해 소통할 수 있습니다.)

   ![Untitled (9)](TIL_7(git_2).assets/Untitled (9).png)

6. 병합이 완료되면 원격 저장소에서 병합이 완료된 브랜치는 불필요하므로 삭제합니다.

   ![Untitled (10)](TIL_7(git_2).assets/Untitled (10).png)

7. master에 브랜치가 병합되면, 각 사용자는 로컬의 master 브랜치로 이동합니다.

   ![Untitled (11)](TIL_7(git_2).assets/Untitled (11).png)

   ```bash
   $ git switch master
   ```

8. 병합으로 인해 변경된 원격 저장소의 master 내용을 로컬에 받아옵니다.

   ![Untitled (12)](TIL_7(git_2).assets/Untitled (12).png)

   ```bash
   $ git pull origin master
   ```

9. 병합이 완료된 master의 내용을 받았으므로, 기존 로컬 브랜치는 삭제합니다. (한 사이클 종료)

   ![Untitled (13)](TIL_7(git_2).assets/Untitled (13).png)

   ```bash
   $ git branch -d feature/login
   ```

10. 새로운 기능 추가를 위해 새로운 브랜치를 생성하며 위 과정을 반복합니다.

    ![Untitled (14)](TIL_7(git_2).assets/Untitled (14).png)

    ```bash
    $ git switch -c feature/pay
    ```

## [2] 원격 저장소 소유권이 없는 경우 (Fork & Pull model)

### (1) 개념

- 오픈 소스 프로젝트와 같이, 자신의 소유가 아닌 원격 저장소인 경우 사용합니다.
- 원본 원격 저장소를 그대로 내 원격 저장소에 `복제`합니다. (이 행위를 `fork`라고 합니다.)
- 기능 완성 후 `Push는 복제한 내 원격 저장소에 진행`합니다.
- 이후 `Pull Request`를 통해 원본 원격 저장소에 반영될 수 있도록 요청합니다.

### (2) 작업 흐름

1. 소유권이 없는 원격 저장소를 `fork`를 통해 내 원격 저장소로 `복제`합니다.

   ![Untitled (15)](TIL_7(git_2).assets/Untitled (15).png)

   아래와 같이 `Fork` 버튼을 누르면 자동으로 내 원격 저장소에 복제됩니다.

   

2. `fork` 후, 복제된 내 원격 저장소를 로컬 저장소에 `clone` 받습니다.

   ![Untitled (16)](TIL_7(git_2).assets/Untitled (16).png)

   ```bash
   $ git clone <https://github.com/edukyle/kakao_clone.git>
   ```

3. 이후에 로컬 저장소와 원본 원격 저장소를 동기화 하기 위해서 연결합니다.

   ![Untitled (17)](TIL_7(git_2).assets/Untitled (17).png)

   ```bash
   # 원본 원격 저장소에 대한 이름은 upstream으로 붙이는 것이 일종의 관례
   
   $ git remote add upstream <https://github.com/AlexKwonPro/kakao_clone.git>
   ```

4. 사용자는 자신이 작업할 기능에 대한 `브랜치를 생성`하고, 그 안에서 `기능을 구현`합니다.

   ![Untitled (18)](TIL_7(git_2).assets/Untitled (18).png)

   ```bash
   $ git switch -c feature/login
   ```

5. 기능 구현이 완료되면, `복제 원격 저장소(origin)`에 해당 브랜치를 `push` 합니다.

   ![Untitled (19)](TIL_7(git_2).assets/Untitled (19).png)

   ```bash
   $ git push origin feature/login
   ```

6. `복제 원격 저장소(origin)`에는 master와 브랜치가 반영되었습니다.

   ![Untitled (20)](TIL_7(git_2).assets/Untitled (20).png)

7. `Pull Request`를 통해 `복제 원격 저장소(origin)의 브랜치`를 `원본 원격 저장소(upstream)의 master`에 반영해달라는 요청을 보냅니다. (원본 원격 저장소의 관리자가 코드 리뷰를 진행하여 반영 여부를 결정합니다.)

   ![Untitled (21)](TIL_7(git_2).assets/Untitled (21).png)

8. `원본 원격 저장소(upstream)`의 master에 브랜치가 병합되면 `복제 원격 저장소(origin)`의 브랜치는 삭제합니다. 그리고 사용자는 로컬에서 master 브랜치로 이동합니다.

   ![Untitled (22)](TIL_7(git_2).assets/Untitled (22).png)

   ```bash
   $ git switch master
   ```

9. 병합으로 인해 변경된 `원본 원격 저장소(upstream)의 master` 내용을 로컬에 받아옵니다. 그리고 기존 로컬 브랜치는 삭제합니다. (한 사이클 종료)

   ![Untitled (23)](TIL_7(git_2).assets/Untitled (23).png)

   ```bash
   $ git pull upstream master
   $ git branch -d feature/login
   ```

10. 새로운 기능 추가를 위해 새로운 브랜치를 생성하며 위 과정을 반복합니다.

    ![Untitled (24)](TIL_7(git_2).assets/Untitled (24).png)

    ```bash
    $ git switch -c feature/pay
    ```

## [3] Pull Request (PR) 자세히 알아보기

> Github 화면을 통해 Pull Request 과정을 자세히 알아봅니다.

1. 브랜치를 Push 하면 `Compare & pull request` 라는 알림 버튼이 나타나는데, 이를 누르면 됩니다.

   ![Untitled (25)](TIL_7(git_2).assets/Untitled (25).png)

2. 혹은 원격 저장소 상단 바에서 `Pull requests → New pull request`을 통해서도 가능합니다.

   ![Untitled (26)](TIL_7(git_2).assets/Untitled (26).png)

3. `base`는 병합될 대상입니다. `master`를 `base`로 두면 됩니다. `compare`는 병합할 대상입니다. 우리가 만든 `feature/login` 브랜치를 `compare`로 두면 됩니다. 그리고 아래쪽에서 비교 내용을 확인하고 `Create pull request`를 클릭합니다.

   ![Untitled (27)](TIL_7(git_2).assets/Untitled (27).png)

4. Pull Request에 대한 제목과 내용, 각종 담당자를 지정하는 페이지가 나옵니다. 모두 작성했다면 `Create pull request`를 눌러서 PR을 생성합니다.

   ![Untitled (28)](TIL_7(git_2).assets/Untitled (28).png)

   `Reviewers` : 현재 PR에 대해 코드 리뷰를 진행해 줄 담당자

   `Assignees` : 현재 PR에 대한 작업을 맡고 있는 담당자

5. PR이 생성되면 다음과 같은 화면이 나타납니다. 빨간 표시가 된 세 부분을 살펴보겠습니다.

   ![Untitled (29)](TIL_7(git_2).assets/Untitled (29).png)

6. `Conversation` : 아래 Write 부분에서 comment를 별도로 작성할 수도 있습니다. 그리고 `Merge pull request` 버튼을 누르면 병합이 시작됩니다. (충돌(conflict) 상황에서는 충돌을 해결하라고 나옵니다.)

   ![Untitled (30)](TIL_7(git_2).assets/Untitled (30).png)

7. `Commits` : PR을 통해 반영될 커밋들을 볼 수 있습니다.

   ![Untitled (31)](TIL_7(git_2).assets/Untitled (31).png)

8. `Files changed` : 파일의 변화 내역들을 볼 수 있습니다.

   ![Untitled (32)](TIL_7(git_2).assets/Untitled (32).png)

9. 코드리뷰를 원하는 라인에서 `+` 를 눌러서 해당 라인에 리뷰를 남길 수 있습니다.

   빨간 사각형으로 표시된 작은 아이콘을 클릭하면, **`suggestion 기능`(코드를 이렇게 바꾸라고 추천하는 기능)**을 넣을 수도 있습니다.

   ![Untitled (33)](TIL_7(git_2).assets/Untitled (33).png)

10. 코드 리뷰를 끝내려면 `Finish your review` 버튼을 누르면 됩니다. 그![Untitled (34)](TIL_7(git_2).assets/Untitled (34).png)

    - `Comment`: 추가적인 comment를 작성할 경우 선택
    - `Approve`: merge를 승인하는 경우 선택
    - `Request change` : 수정해야 하는 사항이 있을 경우 선택

11. 다시 conversation으로 가보면 진행했던 리뷰가 이렇게 나타난 것을 확인할 수 있습니다.

    ![Untitled (35)](TIL_7(git_2).assets/Untitled (35).png)

12. 병합을 하게 되면 아래와 같이 보라색으로 병합이 완료되었다고 나오면 성공입니다.

    `Delete branch` 버튼을 통해 병합된 `feature/login` 브랜치를 지울 수 있습니다. (원격 저장소에서만 지워집니다.)

    ![Untitled (36)](TIL_7(git_2).assets/Untitled (36).png)

13. `master`를 확인해보면 `feature/login`의 내용이 master에 병합된 것을 확인할 수 있습니다.

    ![Untitled (37)](TIL_7(git_2).assets/Untitled (37).png)

14. 이후 로컬 저장소의 master 브랜치에서 `git pull`을 이용해 로컬과 원격을 동기화 합니다.



































