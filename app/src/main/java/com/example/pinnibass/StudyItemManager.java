package com.example.pinnibass;

import com.example.pinnibass.ChapModel.NewChap;
import com.example.pinnibass.ChapModel.NewChapComment;
import com.example.pinnibass.ChapModel.NewChapContents;

import java.io.Serializable;
import java.util.ArrayList;

public class StudyItemManager implements Serializable {


    public NewChap newChap;


    ArrayList<NewStudyItem> likeList = new ArrayList<>();


    public NewChap getNewChap() {
        return newChap;
    }

    public void setNewChap(NewChap newChap) {
        this.newChap = newChap;
    }


    public ArrayList<NewStudyItem> getLikeList() {
        return likeList;
    }

    public void setLikeList(ArrayList<NewStudyItem> likeList) {
        this.likeList = likeList;
    }


    public void addLikeList(ArrayList<NewStudyItem> likeList) {
        if (this.likeList.size() == 0) {
            this.likeList = likeList;
            System.out.println("init likelist");
        } else {
            System.out.println("add likelist");
            likeList.addAll(likeList);
        }
    }


    public void setNewChapData() {

        newChap = new NewChap();

        newChap.setGradeTitle("입문");

        newChap.getNewChapComments().add(new NewChapComment("베이스의 구조와 앰프"));
        newChap.getNewChapComments().add(new NewChapComment("베이스 튜닝법"));
        newChap.getNewChapComments().add(new NewChapComment("연주할 때 바른 자세"));
        newChap.getNewChapComments().add(new NewChapComment("베이스 지판"));
        newChap.getNewChapComments().add(new NewChapComment("근육 훈련 및 스트레칭"));
        newChap.getNewChapComments().add(new NewChapComment("밴드에서의 역할"));
        newChap.getNewChapComments().add(new NewChapComment("악보 읽기"));
        newChap.getNewChapComments().add(new NewChapComment("메트로놈과 크로메틱"));
        newChap.getNewChapComments().add(new NewChapComment("곡 카피하기"));

        newChap.getNewChapComments().
                get(0).getNewChapContents().
                add(new NewChapContents("< Chapter 1. 베이스의 구조와 앰프 >\n" +
                        "\n" +
                        "자- 처음으로 우리는 베이스 구조와 앰프에 대해서 알아볼게요. " +
                        "베이스 구조는 크게 헤드, 넥 바디로 구분합니다. " +
                        "헤드에는 각 줄의 음을 맞추는, 즉 튜닝하는 튜닝키가 있습니다. " +
                        "다음으로 넥에는 지판인 핑거보드, 칸을 구분해주는 프렛 그리고 프렛을 구분해주는 " +
                        "포지션 마크가 있습니다.\n \n마지막으로 바디에는 픽업, 노브 등 여러가지가 구성되어있습니다. " +
                        "노브는 베이스의 종류에 따라 볼륨이나 음역대를 조절할 수 있고, " +
                        "조절하며 내가 원하는 톤을 만들어 연주할 수 있습니다.\n" +
                        "아주 간단하게는 이렇게 입니다!\n \n" +
                        "구조에 대해서 자세히 궁금하시다면,\n 네이버나 구글 검색창 고고!\n"));

        newChap.getNewChapComments().
                get(1).getNewChapContents().
                add(new NewChapContents("< Chapter 2. 베이스 튜닝법 >\n" +
                        "\n" +
                        "베이스 줄을 튜닝하고 싶다면?\n" +
                        "1. 튜닝 기계 및 어플을 준비한다.\n" +
                        "2. 다른 악기로 음을 듣고 따라 맞춘다.\n" +
                        "3. 절대음감이신 분들은 튜닝키를 돌리며 음을 듣고 귀로 맞춰준다.\n" +
                        "저는 1,2번으로 많이 하는데,\n튜닝 어플은 'Pano Tuner'를 추천합니다.\n" +
                        "그럼 무슨 음으로 맞춰줘야 할까요?\n" +
                        "1번줄 : 솔 (가장 얇은 줄) / 2번줄 : 레 / 3번줄 : 라 / 4번줄 : 미 (가장 두꺼운 줄)\n" +
                        "이렇게 4번줄부터 1번줄까지\n 5도 간격으로 맞춰줍니다.\n" +
                        "5도(음정)에 관련해서는\n 추후에 같이 공부해볼게요!\n" +
                        "그럼 Let's Tuning!\n" +
                        "feat. 음 읽기 - 도(C) 레(D) 미(E) 파(F) 솔(G) 라(A) 시(B)" +
                        "+ ex) C는 '도'면서, 'CM 코드 = 도미솔'을 의미하기도 합니다."));

        newChap.getNewChapComments().
                get(2).getNewChapContents().
                add(new NewChapContents("< Chapter 3. 연주할 때 바른 자세 >\n" +
                        "\n" +
                        "제일 중요한 건강을 위해서라도 바른 자세는 매우 중요합니다. " +
                        "오래 연주하게 되면 자세가 곧아도\n아프겠지만, " +
                        "최대한 바른 자세로 연습해주며 스트레칭을 자주 해줍시다!\n" +
                        "\n< 앉은 자세 >\n" +
                        "거울을 마주보고 편하게 앉아준 뒤, 허리를 펴주고 베이스를 오른쪽 허벅지 위에 올려줍니다. " +
                        "그리고 어깨와 목의 긴장을 풀고 오른 팔을 자연스럽게 걸칩니다.\n" +
                        "\n< 손의 자세 >\n" +
                        "오른 손 잡이 : 오른쪽 대각선으로 검지와 중지를 꺾어주고, 끝을 일자로 만들어줍니다. " +
                        "하지만 검지와 중지의 길이 차이가 클 경우 끝이 일자에 가깝다면, 손목과 손의 고질적인 건초염을 심어줄 수 있습니다. " +
                        "검지 중지의 끝은 최대한 맞춰주되, 연주하기에 적당하고 나한테 맞는 자세를 찾아보시길 추천합니다!" +
                        ""));
        newChap.getNewChapComments().
                get(3).getNewChapContents().
                add(new NewChapContents("< Chapter 4. 베이스 지판 >\n" +
                        "\n" +
                        "음계는 #이나 b이 붙지 않은 음은 도 레 미 파 솔 라 시가 있고, " +
                        "이 중 미파와 시도는 반음이여서 중간음이 없지만 " +
                        "다른 음들은 온음이여서 중간에 #과 b이 존재합니다. " +
                        "피아노의 흰색건반 사이에 흑색 건반이 반음이라고 생각해주시면 됩니다." +
                        "\n< 베이스 지판 >\n" +
                        "* 각 줄의 첫번째 음은 \n아무것도 잡지 않은 개방현입니다. *\n" +
                        "[개방현]   ⎮    [1 fret]    ⎮    [2]    ⎮\n" +
                        "1번줄   솔 ⎮  솔# = 라b ⎮    라    ⎮\n" +
                        "2번줄  레  ⎮  레# = 미b ⎮    미    ⎮\n" +
                        "3번줄  라  ⎮  라# = 시b ⎮    시    ⎮\n" +
                        "4번줄  미  ⎮       파        ⎮   파#   ⎮\n" +
                        "\n이렇게 베이스 지판에서는 한 칸씩 반음이 올라갑니다. " +
                        "체크해두고 곧 베이스 지판과 더욱 친해져봐요!" +
                        ""));

        newChap.getNewChapComments().
                get(4).getNewChapContents().
                add(new NewChapContents("< Chapter 5. 근육 훈련 및 스트레칭 >\n" +
                        "\n" +
                        "연주하는 손모양을 바깥쪽 대각선으로 꺾어주면 계속 *위팔노근과 손목이 자극되는데요.\n" +
                        "저같은 경우에는 빠른템포의 슬랩 주법을 계속 연주하다보면, " +
                        "손목은 뻐근하고 팔은 부어서 도라에몽 팔이 되곤 했었어요. " +
                        "[피니의 스트레칭들] 을 알려드릴게요.\n" +
                        "\n" +
                        "1. 목을 앞뒤 좌우 그리고 원을 그리며 잘 풀어주기\n" +
                        "2. 양손의 손가락을 마디마디 크로스해준 뒤, \n손등을 내가 보며 팔을 쭉 펴주기\n" +
                        "+ 그 상태로 손을 V 모양으로 젖혀주어\n새끼 손가락 자극하며 풀어주기\n" +
                        "3. 어깨가 굽지 않게 양손을 등 뒤로 마주 잡아주고 \n팔을 쭉 피고 위로 올려주기\n" +
                        "4. 일어나서 허리 양쪽으로 반 원 그리기\n" +
                        "5. 아시는 스트레칭\n" +
                        "\n" +
                        "Hava a good Time!\n"));

        newChap.getNewChapComments().
                get(5).getNewChapContents().
                add(new NewChapContents("< Chapter 6. 밴드에서의 역할 >\n" +
                        "\n" +
                        "베이스기타는 리듬악기인 드럼과 다른 멜로디 악기들을 연결해주는 줄기와도 같습니다.\n" +
                        "드럼과 함께 리듬의 중심을 잡아주며, 음을 갖고있는 악기여서 " +
                        "피아노, 기타, 색소폰 등등의 멜로디 악기처럼 " +
                        "솔로로 멜로디 연주도 가능합니다!\n" +
                        "\n반주의 역할을 많이 하지만, 원한다면 베이스로 음이나 코드를 연주하며 " +
                        "노래도 할 수 있고, 곡의 멜로디를 내가 연주해줄 수도 있습니다.\n" +
                        "\n" +
                        "✰ Pinni의 수업들을 들으시면서, 원하는 방향과 역할도 함께 찾으셨으면 좋겠습니다. ✰\n" +
                        ""));

        newChap.getNewChapComments().
                get(6).getNewChapContents().
                add(new NewChapContents("< Chapter 7. 악보 읽기>\n" +
                        "\n" +
                        "우리가 악보를 읽을 때 체크해야할 것들을\n간단하게 알려드리겠습니다.\n" +
                        "1. 곡의 제목과 아티스트 - \n원곡을 따라 연주해볼 때 듣기 위해서입니다.\n" +
                        "2. 템포, bpm - 곡의 속도\n" +
                        "3. 음자리표 - 낮은 음자리표는 높은 음자리표 기준 ‘라’가 도입니다.\n" +
                        "4. 조표 - 곡의 키를 확인할 수 있습니다. \n" +
                        "‘Chapter 4’에서 잠시 나왔던 \n#샵과 b플랫으로 구분해줄 수 있습니다. \n" +
                        "5. 박자표 - 4분의 4, 8분의 6 등등 \n다양한 박자표가 있습니다.\n" +
                        "ex) 8분의 6박자는 한 마디의 \n‘8분음표’가 ‘6’개 있다는 뜻입니다.\n" +
                        "내가 좋아하는 곡을 들으며, 곡의 악보를 함께 보시면 더욱 이해가 되실 것입니다.❕\n" +
                        ""));

        newChap.getNewChapComments().
                get(7).getNewChapContents().
                add(new NewChapContents("< Chapter 8. 메트로놈과 크로메틱>\n" +
                        "\n" +
                        "박자 설정 후 클릭 소리를 듣는 ‘메트로놈’ + 메트로놈을 켜고 연습하면 좋은 " +
                        "기초 박자연습 ‘크로메틱’에 대하여 알아보겠습니다!\n" +
                        "< 메트로놈 >\n" +
                        "박자와 템포를 설정할 수 있습니다. " +
                        "* 템포 = 곡의 속도 (숫자) " +
                        "예를 들어 우리가 평범하게 걷는 속도는 50~70 사이, " +
                        "뛰는 속도는 120 정도로 생각하면, 숫자가 높을 수록 속도가 빨라집니다. " +
                        "그럼 크로메틱은 무엇일까요?\n" +
                        "< 크로메틱 >\n" +
                        "박자를 이해하고 쪼개보는 연습입니다. 메트로놈을 한마디의 4분의 4박자, " +
                        "속도를 80으로 설정하고 박수쳐봅시다! " +
                        "‘4분의 4박자’는 한마디의 ‘4분음표’가 ‘네번 = 4박자’가 있는 것입니다.\n" +
                        "그렇다면 박수치는 ‘네번 = 4박자’는, ‘각 한번씩이 4분음표’인 것입니다. " +
                        "박수소리를 녹음해서 들어보고 익숙해지면, 악기로 연습해보면 좀 더 수월하게 하실 수 있습니다." +
                        ""));

        newChap.getNewChapComments().
                get(8).getNewChapContents().
                add(new NewChapContents("< Chapter 9. 곡 카피하기 >\n" +
                        "\n" +
                        "제일 먼저 카피할 곡을 정하고..\n무엇을 하면 좋을까요? \n" +
                        "우선 곡을 많이 들어보는 것입니다.\n" +
                        "그 다음 음과 박자, 이후에 곡의 느낌도 카피해봅니다. " +
                        "음과 박자를 체크할 때는\n입으로 따라 해보는 것도 좋습니다.\n" +
                        "저는 ‘뚜’나 ‘둥’으로 베이스 음을\n따라하곤 했었습니다.\n" +
                        "최대한 원곡의 베이스 기타와 비슷하게\n입으로 따라해보면 더욱 좋습니다.\n" +
                        "\n" +
                        "Shall we copy?️" +
                        ""));


    }

    public void setBeginChapData() {


        newChap = new NewChap();

        newChap.setGradeTitle("초급");

        newChap.getNewChapComments().add(new NewChapComment("자세잡고 익숙해지기"));
        newChap.getNewChapComments().add(new NewChapComment("양손 운지에 익숙해지기"));
        newChap.getNewChapComments().add(new NewChapComment("개방현 4줄 튕기기"));
        newChap.getNewChapComments().add(new NewChapComment("뮤트"));
        newChap.getNewChapComments().add(new NewChapComment("메트로놈과 개방현"));
        newChap.getNewChapComments().add(new NewChapComment("메트로놈과 크로메틱"));
        newChap.getNewChapComments().add(new NewChapComment("악보 읽어보기"));
        newChap.getNewChapComments().add(new NewChapComment("음정에 대하여"));
        newChap.getNewChapComments().add(new NewChapComment("5도권과 scale"));
        newChap.getNewChapComments().add(new NewChapComment("Triad Chord"));
        newChap.getNewChapComments().add(new NewChapComment("7th Chord"));
        newChap.getNewChapComments().add(new NewChapComment("노래 카피"));


        newChap.getNewChapComments().
                get(0).getNewChapContents().
                add(new NewChapContents("< Chapter 1. 자세잡고 익숙해지기 >\n" +
                        "\n" +
                        "기본적으로 앉아서나 서서 연주합니다. ‘Pinni’의 팁을 말씀드려볼게요!\n" +
                        "< 앉아서 연습할 때 >\n" +
                        "우선 의자에 등을 약간 떼고 앉습니다. 거울을 마주보고 앉으시면 더욱 좋습니다.✨ " +
                        "다리는 V자, 베이스는 두 손으로 잘 잡아서 배에 가깝게 당겨주시고, " +
                        "허벅지 위에 베이스를 올려주는데, 각도는 연주하는 손 반대쪽 대각선으로 맞춰주시면 됩니다. " +
                        "허벅지는 악기 아랫쪽이 ⌒ ⇠ 들어가있는 부분에 맞춰주세요. 베이스가 흔들리지 않게 잘 고정해주세요.\n" +
                        "< 연주하는 손 >\n" +
                        "연주하는 손의 엄지손가락 안쪽을 가장 위의 픽업에 올리고, 팔은 베이스 윗쪽에 편하게 기대주세요. " +
                        "그러면 손목부터 팔까지 1/3 위치 정도에 닿습니다. " +
                        "픽업에 엄지손가락을 올려주고, 검지와 중지 끝을 힘들지 않을 정도로 꺾어서" +
                        "일정하게 만든  줄을 벽에 기대며 검지와 중지를 번갈아 튕겨주시면 됩니다.✌" +
                        ""));

        newChap.getNewChapComments().
                get(1).getNewChapContents().
                add(new NewChapContents("< Chapter 2. 양손 운지에 익숙해지기 >\n" +
                        "\n" +
                        "전 시간에는 자세에 대해서 함께 알아봤어요! 이번에는 연주하는 ‘손’에 대해서 알아보겠습니다." +
                        "오른손잡이를 기준으로 말씀드릴게요. 왼손잡이신 분은 반대로 생각해주십시오!\n" +
                        "< 오른손 >\n" +
                        "오른손은 저번시간에 말했던대로 가장 위의 픽업에 엄지손가락을 얹어주고 / 오른쪽 대각선으로 손가락을 틀어줍니다. \n" +
                        "각도는 ‘검지와 중지끝을 힘들지않을 정도로 일정하게’ 맞춰주시면 됩니다.\n" +
                        "< 왼손 >\n" +
                        "아직 사용하지 않은 왼손은 음을 잡지 않으신다면 줄이 닿지않게 넥을 잡아주시면 됩니다.\n" +
                        ""));

        newChap.getNewChapComments().
                get(2).getNewChapContents().
                add(new NewChapContents("< Chapter 3. 개방현 4줄 튕기기 >\n" +
                        "\n" +
                        "도(C) 레(D) 미(E) 파(F) 솔(G) 라(A) 시(B)\n" +
                        "[베이스 지판]\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "4번줄 개방현 = 미 (E)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "3번줄 개방현 = 라 (A)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "2번줄 개방현 = 레 (D)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "1번줄  개방현 = 솔 (G)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "오른손은 픽업에 엄지손가락을 올려준 뒤 손가락은 20도 이상의 각도로 꺾어주고, " +
                        "검지와 중지 끝을 힘들지않을 정도로 일정하게 만듭니다. ✌ " +
                        "검지와 중지를 번갈아서 튕길 때마다, 손가락을 벽에 기대주며 위의 줄부터 아랫줄로 내려가보며 연주해봅시다.\n" +
                        "< 습관들여야 할 부분✔ >️\n" +
                        "1번줄 2번줄 이렇게 아랫줄부터 올라올 때는, 마지막 연주한 손가락을 그대로 올라와야합니다. " +
                        "예를들어 검지 중지를 1번줄에서 연주하고 2번줄로 올라온다면 중지를 그대로 기대서 " +
                        "2번줄로 올라오는 것입니다.\n" +
                        ""));

        newChap.getNewChapComments().
                get(3).getNewChapContents().
                add(new NewChapContents("< Chapter 4. 뮤트 >\n" +
                        "\n" +
                        "<How to mute>\n" +
                        "❹번줄 - ‘왼손’을 클립모양으로 생각하고 엄지 ⌊넥⌋ 손가락들 모양으로 " +
                        "손가락들을 ‘1번줄까지 3번줄까지 붙혀주고' " +
                        "[뮤트] -- 4번줄의 프렛을 잡을 때는 손가락을 펴서 손끝부분 살로 잡아줍니다.\n" +
                        "❸번줄 - 3번줄을 튕길 때 4번줄에 ’오른손’ 엄지 윗등을 기대주면 됩니다. " +
                        "또는 ‘왼손’가락 중 쓰지않는 손가락을 쭉 펴서 [뮤트]해줄 수 있습니다." +
                        "ex) 3번줄 2프렛을 검지로 잡아줬을 때 중지부터 새끼손가락까지 자연스레 쭉 펴서 줄에 기대주면 됩니다.\n" +
                        "❷번줄 - ‘왼손’은 1번줄만 잡아주거나, 쓰지않는 손가락을 쭉 펴서 [뮤트]해줄 수 있고, " +
                        "이번엔 ‘오른손 엄지손가락’이 이동합니다. 오른손 엄지손가락을 픽업에서 ➡️ 4번줄로 이동해주세요. " +
                        "그리고 2번줄을 튕길 때 3번줄에 엄지 윗등을 기대주면 됩니다.\n" +
                        "❶번줄 - 오른손 위주로 뮤트를 합니다. 오른손 엄지손가락을 이번엔 ➡️ 3번줄로 이동시킵니다. " +
                        "그리고 엄지 윗등을 4번줄에 살짝 기대줍니다.\n" +
                        ""));

        newChap.getNewChapComments().
                get(4).getNewChapContents().
                add(new NewChapContents("< Chapter 5. 메트로놈과 개방현❕ >\n" +
                        "\n" +
                        "메트로놈을 켜고 개방현을 연주해보겠습니다.✌\n" +
                        "기본적인 음표와 박자를 먼저 설명하겠습니다.\n" +
                        "<4분의 4박자 ♩ 4분음표 설정 기준>\n" +
                        "온음표 \\ / \\ / X4 (4분음표 4개를 합친 길이) 클릭 4개가 나오는 동안의 길이\n" +
                        " ♩ 4분음표 \\ / \\ / (8분음표 2개를 합친 길이) 클릭 1개의 길이\n" +
                        "♫ 8분음표 \\ / (16분음표 2개를 합친 길이) 클릭 1/2개의 길이\n" +
                        "♬ 16분음표 \\ 클릭 1/4개의 길이\n" +
                        "bpm을 바꿔보며, 여러음표로 연습해봅시다!\n" +
                        "ex) 메트로놈을 4분의 4박자 ♩ 4분음표 설정 기준\n" +
                        "bpm = 60 / 4분음표, 8분음표, 16분음표 순으로 연습하다가 " +
                        "bpm 5씩 추가 ✚ 60 → 65 → 70 ++\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "4번줄 - 미 미 미 미\n" +
                        "3번줄 - 라 라 라 라\n" +
                        "2번줄 - 레 레 레 레\n" +
                        "1번줄 - 솔 솔 솔 솔\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        ""));

        newChap.getNewChapComments().
                get(5).getNewChapContents().
                add(new NewChapContents("< Chapter 6. 메트로놈과 크로메틱 >\n" +
                        "\n" +
                        "메트로놈을 켜고 크로메틱을 연습해보겠습니다!\n" +
                        "앞서 배웠던 음과, 박자를 이용해볼게요! 예시를 알려드리겠습니다.\n" +
                        "ex) 메트로놈 4분의 4박자 ♩ 4분음표 설정 기준\n" +
                        "bpm = 60 / 4분음표, 8분음표, 16분음표 순으로 연습하다가 bpm 5씩 추가 ↑ 60 → 65 → 70 ++\n" +
                        "왼손가락 번호 1234 = 검지, 중지, 약지, 새끼손가락 순서\n" +
                        "*보기 쉽게 음을 넘어갈 때는 \nb을 쓰지않고 #으로 표현\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "4번줄 =  미    파     파#   솔\n" +
                        "3번줄 =  라    라#   시     도\n" +
                        "2번줄 =  레    레#   미     파\n" +
                        "1번줄 =  솔#   라     시    도\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "ex2) 왼손가락 번호 1324 = 검지, 약지, 중지, 새끼손가락 순서 --" +
                        "4번줄 = 미 파# 파 솔 (다른줄도 똑같이 1프렛씩 올라가게) " +
                        "손가락번호를 설정하여 4번줄 -> 1번줄 *아래로 / 1번줄 -> 4번줄 *위로 " +
                        "순차적으로 메트로놈과 함께 목표 템포를 정해서 연습해봅시다!" +
                        ""));

        newChap.getNewChapComments().
                get(6).getNewChapContents().
                add(new NewChapContents("< Chapter 7. 악보 읽어보기 >\n" +
                        "\n" +
                        "악보 읽기 .. 어려울 것 같은데..  괜찮습니다. " +
                        "감만 잡으시면 읽어보는 만큼 성장할 수 있는 부분입니다.\n" +
                        "[악보 읽을 때 체크리스트✔️]\n" +
                        "1. 음자리표\n" +
                        "2.조표 (key) ♭♯ " +
                        " - b이나 #이 없으면 CMkey = Amkey로 볼 수 있습니다. \n" +
                        "3.박자표 - 종류 : 4분의 4박자, 8분의 6박자 등등 \n" +
                        "4.곡의 제목과 원곡자 - 악보를 읽고, 곡을 카피하고 싶을 때 " +
                        "원곡을 들으면서 카피하기때문에 꼭 체크해야하는 부분입니다.\n" +
                        "5.bpm (tempo) - 곡의 속도를 체크합니다.\n" +
                        "우리는 우선 여기까지 알아보고 넘어갈게요\n" +
                        "6.++ - 곡의 흐름 - ex) Intro, Verse A, Bridge B 등 + " +
                        "악상 기호 및 기보법 - 다카포, 달세뇨, 도돌이표 등\n" +
                        ""));

        newChap.getNewChapComments().
                get(7).getNewChapContents().
                add(new NewChapContents("< Chapter 8. 음정 >\n" +
                        "\n" +
                        "음정의 관계는 크게 3가지 종류로 나뉩니다.\n" +
                        "⓵ 완전 / " +
                        "⓶ 장 / " +
                        "⓷ 단 " +
                        "\n" +
                        "CM키 기준으로 순서대로 예시를 들어 설명해드릴게요!\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 같은 도 = 완전 1도 (같은 음)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 도# = 감 1도\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 레 = 장 2도 (도 레 = 온음 1개)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 미b = 단 3도 (도 레 미b = 온음 1개 + 반음 1개)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 미 = 장 3도 (도 레 미 = 온음 2개)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 파 = 완전 4도 (온음 2개 + 반음 1개)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "도와 솔b = 감 5도\n" +
                        " 등.. " +
                        "장에서 반음이 내려가면 '단' / 단이나 완전에서 반음이 내려가면 '감' / " +
                        "완전이나 장에서 반음이 올라가면 '증' ✔" +
                        ""));

        newChap.getNewChapComments().
                get(8).getNewChapContents().
                add(new NewChapContents("< Chapter 9. 5도권과 스케일 >\n" +
                        "\n" +
                        " ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n" +
                        "       ⇣          CM              ⇣\n" +
                        "    ♭   F                  G      ♯\n" +
                        "  Bb                          D\n" +
                        "     Eb       ⚪️5도권⚪         A \n" +
                        "    Ab                        E\n" +
                        "     Db                  B\n" +
                        "        Gb\n" +
                        " ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n" +
                        "♭추가 순서 = 시 미 라 레 솔 도 파\n" +
                        "♯추가 순서 = 파 도 솔 레  라 미 시\n" +
                        "feat. 나란한 조 - Major 키 기준으로 단 3도 (온음+반음) 아래 " +
                        "minor 키 기준으로 단 3도 위를 루트로 생각하면 됩니다. " +
                        "[CM key = Am key]\n" +
                        "C Major Scale = 도 레 미 파 솔 라 시 도\n" +
                        "1(루트) 2 3 4 5 6 7 8(루트)\n" +
                        "Am Scale = 라 시 도 레 미 파 솔 라\n" +
                        "1(루트) 2 b3 4 5 b6 b7 8(루트)\n" +
                        "메이저 (Major) = M (밝은 느낌) / 마이너 (minor) = m (어두운 느낌) --" +
                        "구성음은 같지만, 키가 다르고 메이저와 마이너로 구분합니다.❗️\n" +
                        ""));

        newChap.getNewChapComments().
                get(9).getNewChapContents().
                add(new NewChapContents("< Chapter 10. Triad Chord >\n" +
                        "\n" +
                        "< Triad Chord >\n" +
                        "3화음으로 구성된 ‘Triad Chord’를 알아보겠습니다. " +
                        "루트 'C'기준 예시입니다." +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "CM = 도 미 솔 (1 3 5)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Cm = 도 미b 솔 (1 b3 5)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Caug (=C+) = 도 미 솔# (1 3 5#)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Csus4 = 도 파 솔 (1 4 5)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Cdim = 도 미b 솔b (1 b3 b5)\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "악보에 12key로 다 적어볼까요? " +
                        "다 적고나시면 머리에 쏙 들어와있으실 겁니다☺️\n" +
                        ""));

        newChap.getNewChapComments().
                get(10).getNewChapContents().
                add(new NewChapContents("< Chapter 11. 7th Chord >\n" +
                        "\n" +
                        "7th 코드는 스케일의 1 3 5 7도로 구성되어있습니다. " +
                        "ex) CM7 = 도 미 솔 시\n" +
                        "여기서 이 코드의 색깔을 가장 강력하게 정해주는 음들이 있습니다. " +
                        "바로 3도와 7도인데요! 이 음들을 ’가이드톤’이라고 합니다. " +
                        "ex) CM7 - 미와 시\n" +
                        "가이드톤을 기준으로 보시며 7th 코드를 함께 봐볼까요? " +
                        "+ check - 7(=b7)과 M7(=7)입니다.❗️\n" +
                        "CM7 = 도 미 솔 시\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Cm7 = 도 미b 솔 시b\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "CmM7 = 도 미b 솔 시\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "C7 (=C Dominant 7) = 도 미 솔 시b\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Caug7 = 도 미 솔# 시b\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "C7sus4 = 도 파(미#) 솔 시b\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "Cm7(b5) = 도 미b 솔b 시b\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤ 등\n" +
                        ""));

        newChap.getNewChapComments().
                get(11).getNewChapContents().
                add(new NewChapContents("< Chapter 11. 노래 카피 >\n" +
                        "\n" +
                        "이제 곡을 하나 정하고 카피해보면 좋을 것 같아요!\n" +
                        "제 첫 카피곡은 ‘롤러코스터 - Last Scene’이였습니다.\n" +
                        "\n" +
                        "<카피 순서>\n" +
                        "1. 곡 정하기\n" +
                        "2. 곡 제목과 아티스트 적어주기\n" +
                        "3. 음자리표 적기 (베이스는 낮은음자리표)\n" +
                        "4. 조표 적어주기 ex)FM = 시b\n" +
                        "5. 박자표 적기 ex) 4/4 6/8 등\n" +
                        "6. 악보 칸 나눠주기 (대부분 한 줄마다 4마디나 3마디씩 나눠주기)\n" +
                        "7. 노래 들으며 파트를 줄 왼쪽에 적어주기 ex) Intro (8마디), Verse A (9마디부터)\n" +
                        "8. 악보 적는 과정에 모르면 물어보거나 찾아보고, 끝까지 카피해보기" +
                        ""));

    }

    public void setInterChapData() {


        newChap = new NewChap();

        newChap.setGradeTitle("중급");

        newChap.getNewChapComments().add(new NewChapComment("Groove (그루브)"));
        newChap.getNewChapComments().add(new NewChapComment("'X' 고스트 노트"));
        newChap.getNewChapComments().add(new NewChapComment("해머링온과 풀링오프"));
        newChap.getNewChapComments().add(new NewChapComment("심화 크로메틱"));
        newChap.getNewChapComments().add(new NewChapComment("악보읽기 심화편"));
        newChap.getNewChapComments().add(new NewChapComment("비브라토 (~~)"));
        newChap.getNewChapComments().add(new NewChapComment("펜타토닉 스케일"));
        newChap.getNewChapComments().add(new NewChapComment("코드톤과 패싱톤"));
        newChap.getNewChapComments().add(new NewChapComment("장르에 대하여"));


        newChap.getNewChapComments().
                get(0).getNewChapContents().
                add(new NewChapContents("< Chapter 1. Groove >\n" +
                        "음악에서 그루브 (groove)는 충동적인 리듬의 ‘필’ 또는 ‘스윙’의 감각입니다. " +
                        "한국말로는 ‘맛깔스럽다’ 라는 표현이 가장 비슷할 것 같습니다. " +
                        "똑같은 리듬, 똑같은 라인을 연주해도 더 맛깔스럽고, " +
                        "뭔가 어깨가 들썩이고 몸이 절로 움직이게 되는 느낌입니다. " +
                        "그럼 이런 그루브를 향상시키기 위해서는 어떤 연습을 해야할까요? " +
                        "(1) 첫번째는 일정한 템포의 유지 ♩ " +
                        "(2) 엑센트 *포인트 살려주기 ıllılı.ı" +
                        "(3) 미세하게 아주 약간 느리게 연주하기" +
                        "그리고 가장 중요한 건 ‘쉼표’입니다. " +
                        "일정한 템포로 연주하고, 엑센트도 잘 살려주고 " +
                        "약간 느리게 연주해도.. 쉼표에서 잘 쉬어주지 않으면 " +
                        "음표의 길이가 결국 무의미해질 수 있습니다. " +
                        "2분쉼표, 4분쉼표, 8분쉼표, 16분쉼표 등을 함께 연습해볼까요?\n" +
                        "-- 1마디 기준 도돌이표 (반복) --\n" +
                        "1.2분음표 • 2분 쉼표\n" +
                        "2.ㅋ분음표 • 4분쉼표 • 4분음표 • 4분쉼표\n" +
                        "3.8분음표 2개 • 4분쉼표 • 8분음표 2개 • 4분쉼표\n" +
                        "등등 간단한 것부터 16분쉼표까지 악보에 패턴 종류를 그려보며 연습해봅시다." +
                        ""));

        newChap.getNewChapComments().
                get(1).getNewChapContents().
                add(new NewChapContents("< Chapter 2. 'X' Ghost Note >\n" +
                        "\n" +
                        "고스트노트는 베이스 라인에 리드미컬한 느낌을 더해주는데 매우 효과적입니다.\n" +
                        "왼손으로 줄이 울리지 않도록 뮤트한 후, 한음 한음을 정확히 내야 하고,\n" +
                        "내가 내려고 하는음과 뮤트한 음이 구분될 수 있도록 연주해야합니다." +
                        "예시입니다. 한 마디 기준 ⎮\n" +
                        "1.8분음표 기준 \n 도 X 도# X ⎮ 레 X 레# X ⎮ 도 X 도# X ⎮ 레 X 레# X ⎮\n" +
                        "2.16분음표 기준 \n 도 X X X 레 X X X 솔 X X X 라 X X X ⎮\n" +
                        "등\n" +
                        "이런식으로 음과 고스트 노트를 조합해서 연습해봅시다!" +
                        ""));


        newChap.getNewChapComments().
                get(2).getNewChapContents().
                add(new NewChapContents("< Chapter 3. 해머링 온과 풀링오프 >\n" +
                        "\n" +
                        "< 해머링 온 (+hammer on) >\n" +
                        "첫음을 연주한 뒤 두번째 음은 오른손으로 피킹하지 않고, " +
                        "왼손의 다른 손가락으로 지판을 때리듯이 줄을 눌러서 소리낸다.\n" +
                        "< 풀링오프 (pulling off) >\n" +
                        "해머링 온과는 정반대로 줄을 누르고 있던 " +
                        "손가락을 빠르게 떼어내면서 다음 음을 지속시킨다.\n" +
                        "\n" +
                        "이 주법을 사용하기 위해서는 왼손 힘이 충분해야 하는데요. " +
                        "힘이 부족하시다면 아마 부들부들,,, 으악 하실 수 있습니다. " +
                        "그래서 크로메틱 연습하고 생각나실 때마다 틈틈히 연습해서 " +
                        "익숙해지시는 것을 추천합니다.✨\n" +
                        ""));

        newChap.getNewChapComments().
                get(3).getNewChapContents().
                add(new NewChapContents("< Chapter 4. 크로메틱 Level 2 >\n" +
                        "\n" +
                        "어떤 식으로 패턴을 짜면 좋을지 몇가지 예시를 알려드리겠습니다❕\n" +
                        "1. 줄을 이동하는 패턴\n" +
                        "1324 3241\n" +
                        "3번줄/2번줄 —— 1/3 2/4 • 3\\2 4\\1\n" +
                        "⚠️주의 - 손가락을 전부 붙힌채로 움직일 손가락만 움직이기\n" +
                        "2. 새끼손가락 단련하기\n" +
                        "ex) 손가락 번호를 4로 시작하게 설정한다.\n" +
                        "4321 / 4231 / 4321 / 4123 등\n" +
                        "3. 6연음 연습해보기 \n" +
                        "템포를 40정도로 맞추고 4분음표를 기준으로 6개씩 쪼개서 연주해봅시다.\n" +
                        "4. ’Ghost Note’ 를 섞은 패턴\n" +
                        "5. ’Hammer on, Pull Off’를 섞은 패턴\n" +
                        "6. Diatonic Scale (12key Major,minor scale 등)\n" +
                        "Let’s Chromatic❗️" +
                        ""));


        newChap.getNewChapComments().
                get(4).getNewChapContents().
                add(new NewChapContents("< Chapter 5. 악보읽기 Level 2 >\n" +
                        "\n" +
                        "연주를 하려고 악보를 보다보면, " +
                        "베이스 음이 안 적혀있는 경우가 많습니다. " +
                        "그럴 때는 어떻게 연주해야 할까요?\n" +
                        "\n" +
                        "♭♯♮ 우선 조표를 확인해서 이 곡의 key를 알아내고, " +
                        "코드를 확인하고 이 곡의 메인 리듬을 확인합니다. " +
                        "혹시 메인 리듬이 적혀있지 않다면 원곡을 들어보거나, " +
                        "함께하는 연주자한테 빠르게 이 곡에 대해서 " +
                        "얘기해보거나 물어보면 좋습니다.\n" +
                        "\n" +
                        "곡의 흐름도 체크해주어야 합니다. " +
                        "악상 기호가 많아지면, (*D.C / D.S / Coda ••• 등) " +
                        "악보를 따라 순차적으로 진행되는 것이 아니기에 잘 체크해놔야 합니다. \n" +
                        ""));

        newChap.getNewChapComments().
                get(5).getNewChapContents().
                add(new NewChapContents("< Chapter 6. 비브라토 >\n" +
                        "\n" +
                        "비브라토는 밴딩에서 폭만 줄여서 떨림을 주는 연주법입니다.\n" +
                        "떨리는 음간격이 너무 불규칙적이면 부자연스럽고, " +
                        "간혹 비브라토가 중간 중간 뚝뚝 끊겨버리기도 합니다.\n" +
                        "\n" +
                        "비브라토의 종류는 다양하지만 우리는 우선 " +
                        "줄을 꾹누르고 폭을 좁게 위아래로 움직이는 " +
                        "밴딩 비브라토를 연습해보겠습니다.\n" +
                        "\n" +
                        "☛ ▶︎ 유튜브에서 예시 영상을 찾아보면 더욱 좋습니다." +
                        ""));

        newChap.getNewChapComments().
                get(6).getNewChapContents().
                add(new NewChapContents("< Chapter 7. 펜타토닉 스케일 >\n" +
                        "\n" +
                        "펜타토닉 스케일은 다섯개의 대표음으로 이루어진 스케일(five-note scale)입니다. " +
                        "스케일을 외우고, 지판과 연결해서 사용하기에 형식을 알아보겠습니다.\n" +
                        "[Major Pentatonic]\n" +
                        "메이저 스케일의 1, 2, 3, 5, 6음\n" +
                        "ex) " +
                        "C Major Pentatonic = 도 레 미 솔 라 " +
                        "* 나란한 조의 스케일은 시작음은 다르나 구성음이 같습니다." +
                        "CM key = Am key 입니다.\n" +
                        "[Minor Pentatonic]\n" +
                        "마이너 스케일에서 1, b3, 4, 5, b7\n" +
                        "ex) " +
                        "A minor Pentatoic = 라 도 레 미 솔 " +
                        "펜타토닉 스케일도 음악노트에 12key로 적어봅시다❗️" +
                        ""));

        newChap.getNewChapComments().
                get(7).getNewChapContents().
                add(new NewChapContents("< Chapter 8. 코드톤과 패싱톤 >\n" +
                        "\n" +
                        "이번 시간엔 비화성음에 대하여 알아볼게요! " +
                        "비화성음은 코드의 구성음(=코드톤)이 아닌 음을 말합니다. " +
                        "CM7 코드의 코드톤으로 생각한다면, 도 미 솔 시를 제외한 " +
                        "레 파 라를 생각할 수 있습니다. " +
                        "이 음들은 텐션이라는 개념으로 쓸 수 있지만, " +
                        "이번 챕터에서는 패싱톤에 대해서 알아보겠습니다.\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "[Passing Tone] p / pt / pn\n" +
                        "‘경과음’, ‘지남음’이라고 하며 높이가 다른 2개의 화성음 사이에 " +
                        "다리를 놓아주는 음입니다.\n" +
                        "ex) " +
                        "Dm7 - Bm7(b5) 코드 진행이라면 " +
                        "레 - *도 - 시로 코드를 갈 수 있습니다. " +
                        "그럼 여기서 *도 가 패싱톤의 역할을 합니다!\n" +
                        "⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤\n" +
                        "이제 다음 코드를 넘어갈 때 패싱톤을 써주어봅시다❗️\n" +
                        ""));

        newChap.getNewChapComments().
                get(8).getNewChapContents().
                add(new NewChapContents("< Chapter 9. 장르에 대하여 >\n" +
                        "\n " +
                        "ıllılı.ı ıllılı.ı\n" +
                        "[Classic] " +
                        "[Jazz] " +
                        "[CCM]\n" +
                        "[Pop] " +
                        "Olivia Dean - Reason To Stay \n" +
                        "[Ballad] " +
                        "[Blues] " +
                        "B B King - The Trill Is Gone\n" +
                        "[R&B] " +
                        "Eric Benet /" +
                        "한국 아티스트 = 죠지, 주영\n" +
                        "[Hip-Hop] " +
                        "Cautious Clay -  Cold War\n" +
                        "[Country] " +
                        "Nickel Creek - This Side\n" +
                        "[Folk] " +
                        "[Reggae] " +
                        "Bob Marley - Natural Mystic\n" +
                        "[Disco] " +
                        "Earth, Wind & Fire - September\n" +
                        "[Rock] " +
                        "[K-Pop] " +
                        "[Troat] " +
                        "[City-Pop] " +
                        "Maria Takeuchi - Plastic Love\n" +
                        "[Dance] " +
                        "[EDM] " +
                        "[Rock and Roll] " +
                        "Buddy Holly - Peggy Sue\n" +
                        "[Finger Style] " +
                        "Tommy Emmanuel / " +
                        "자이로\n" +
                        ""));

    }
}
