// 参考にしたwebサイト
// http://nmksb.seesaa.net/article/141920896.html

import java.io.*;

public class FileControl {
	//操作したいディレクトリー
	File fileDir;
	//fileDirで指定したディレクトリーのファイル一覧
	String[] fileList;
	//操作したいディレクトリー名
	String directoryName = "../TestFiles/";

	public FileControl() {
		fileDir = new File( directoryName );
		//初期化時にファイルのリストを取得
		fileList = fileDir.list();
	}

	//テスト用メソッド
	//ファイル一覧を表示するだけ
	public void showFileList() {
		System.out.println( "showFileList() begin" );
		for( String fname : fileList ) {
			System.out.println( fname );
		}
		System.out.println( "showFileList() finish" );
		System.out.println( "" );
	}

	//全てのファイルを削除する(ディレクトリーは削除しない)
	public void deleteAllFiles() {
		for( int i = 0; i < fileList.length; i++ ) {
			File tempFile = new File( directoryName + fileList[i] );
			if( tempFile.exists() && tempFile.isFile() ) {
				if( tempFile.delete() ) {
					System.out.println( "[SUCCESS] " + fileList[i] );
				} else {
					System.out.println( "[FAILED] " + fileList[i] );
				}
			} else if( tempFile.isDirectory() ) {
				System.out.println( "[PASS] " + fileList[i] + " :: it's a directory" );
			} else {
				System.out.println( "Can't find " + fileList[i] );
			}
		}
	}
	
	//全てのディレクトリーを削除する(ファイルは削除しない)
	public void deleteAllDirectories() {
		for( int i = 0; i < fileList.length; i++ ) {
			File tempFile = new File( directoryName + fileList[i] );
			if( tempFile.exists() && tempFile.isDirectory() ) {
				if( tempFile.delete() ) {
					System.out.println( "[SUCCESS] " + fileList[i] );
				} else {
					System.out.println( "[FAILED] " + fileList[i] );
				}
			} else if( tempFile.isFile() ) {
				System.out.println( "[PASS] " + fileList[i] + " :: it's a file" );
			} else {
				System.out.println( "Can't find " + fileList[i] );
			}
		}
	}
}
