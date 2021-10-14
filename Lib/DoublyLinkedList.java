package aoj.itp1;
import java.util.Scanner;

//import aoj.itp1.MyLinkedList.DoublyListNode;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//命令数
		int n = sc.nextInt();
		MyLinkedList list = new MyLinkedList();

		for(int i = 0;i < n;i++) {
			//命令
			String command = sc.next();

			switch (command) {
			//連結りすとの先頭にキーxを持つ要素を挿入
			case "insert":
				int insertKey = sc.nextInt();
				list.addAtHead(insertKey);
				break;
			//
			case "delete":
				int deleteKey = sc.nextInt();
				list.delete(deleteKey);
				break;
			case "deleteFirst":
				list.deleteFirst();
				break;
			case "deleteLast":
				list.deleteLast();
				break;
			}
		}

		DoublyListNode node = list.head;
		while(true) {
			if(node.next == null) {
				System.out.println(node.val);
				break;
			}
			System.out.print(node.val + " ");
			node = node.next;
		}
		sc.close();
	}
	/**
	 * 双方向リストのノード
	 */
	 static class DoublyListNode{
		int val;
		//nodeの前後->前後を連結します。
		DoublyListNode next,prev;
		/**
		 * コンストラクタ
		 * @param x
		 */
		DoublyListNode(int x) {val = x;}
	}

	static class MyLinkedList{
		//現在の先頭ノード
		DoublyListNode head = null;

		/**
		 * 引数として渡されたindexのnodeを探して、データを返す
		 * @param index nodeが格納されている位置
		 * @return indexの位置にある数字を返す。
		 */
		public int get(int index) {
			if(head == null) {
				return -1;
			}

			//先頭のnodeを獲得する
			DoublyListNode cur = head;
			for(int i = 0;i < index;i++) {
				if(cur.next == null) {
					return cur.val;
				}
				cur = cur.next;

			}
			return cur.val;
		}

		/**
		 * リストの先頭に追加
		 * @param val 追加する値
		 */
		public void addAtHead(int val) {
			//リストが空の時
			if (head == null) {
				head = new DoublyListNode(val);
				return;
			}
			//nodeを呼び出します。
			DoublyListNode node = new DoublyListNode(val);
			//node(次のリストの先頭)のnextに今のリストの先頭を繋ぐ
			node.next = head;
			//今のリストの先頭の前にnodeを繋ぐ
			head.prev = node;

			//先頭をnodeに変える。
			head = node;
		}

		/**
		 * リストの最後にnodeを追加する。
		 * @param val
		 */
		public void addAtTail(int val) {
			if(head == null) {
				head = new DoublyListNode(val);
				return;
			}

			DoublyListNode cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			DoublyListNode node = new DoublyListNode(val);
			//nodeより前の値を連結する。
			node.prev = cur;
			//curnodeの次にnodeを連結する。
			cur.next = node;
		}

		/**
		 * 特定のindexにnodeを追加する。
		 * @param index 追加する位置
		 * @param val　追加する値
		 */
		public void addAtIndex(int index,int val) {
			if(head == null) {
				if(index == 0) {
					head = new DoublyListNode(val);
				}
				return;
			}

			//特定のindexのnode(cur)を検索する
			DoublyListNode cur = head;
			DoublyListNode prev = null;
			for(int i = 0;i < index;i++) {
				prev = cur;
				cur = cur.next;
			}

			//prevnodeと新noodeを接続する。
			DoublyListNode node = new DoublyListNode(val);
			//prevが存在しない時->先頭の時
			if(prev == null) {
				node.next = head;
				head.prev = node;
				head = node;
			}else if(cur == null) { //curがnull->末尾
				cur = node;
				prev.next = cur;
				cur.prev = prev;
			}else {
				prev.next = node;
				node.prev = prev;
				node.next = cur;
				cur.prev = node;
			}
		}

		/**
		 * 特定のindexのnodeを削除
		 * @param index
		 */
		public void deleteAtIndex(int index) {
			if(head == null) {
				return;
			}

			//indexの値を検索
			DoublyListNode cur = head;
			for(int i = 0;i < index;i++) {
				cur = cur.next;
			}

			DoublyListNode prev = cur.prev;
			DoublyListNode next = cur.next;

			if(prev == null) {
				head = next;
			}else if(next == null) {
				prev.next = null;
			}else {
				prev.next = next;
				next.prev = prev;
			}
		}
		/**
		 * valを持つ最初の要素を連結リストから削除する。
		 * @param val
		 */
		public void delete(int val) {
			if(head == null) {
				return;
			}
			DoublyListNode cur = head;
			while(cur != null) {
				if(cur.val == val) {
					//現在のノードの要素と引数のvalが一致する時
					DoublyListNode prev = cur.prev;
					DoublyListNode next = cur.next;

					if(next == null) {
						//変数curが末尾ノードの時
						prev.next = null;
					}else if(prev == null) {
						//変数curが先頭ノードの時
						head = next;
					}else {
						//変数curにprevとnextが存在する時
						prev.next = next;
						next.prev = prev;
					}

					break;
				}

				//次の値に更新する
				cur = cur.next;
			}
		}

		/**
		 * リストの末尾を削除する
		 */
		public void deleteLast() {
			if(head == null) {
				return;
			}

			DoublyListNode cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}

			DoublyListNode prev = cur.prev;
			DoublyListNode next = cur.next;

			if(prev == null) {
				//変数curが先頭ノードの場合
				head = next;
			}else {
				prev.next = null;
			}
		}

		/**
		 * 先頭ノードを削除する
		 */
		public void deleteFirst() {
			if(head == null) {
				return;
			}

			DoublyListNode curNode = head;

			DoublyListNode nextNode = curNode.next;
			nextNode.prev = null;
			curNode.next = null;
			head = nextNode;
		}
}

}


