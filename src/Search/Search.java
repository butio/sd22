package Search;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dao.Dao;

public class Search {



	public static ArrayList<String> MusicSearch(String targetColumn,String where,String searchCode1,String searchCode2){
		ArrayList<String>tbl = new ArrayList<String>();
		String sql = "SELECT DISTINCT " + targetColumn +" FROM album" +
				" INNER JOIN music ON album.album_id = music.album_id" +
				" INNER JOIN contribution ON contribution.album_id = music.album_id && contribution.album_count = music.album_count" +
				" INNER JOIN band ON contribution.band_id = band.band_id";
		if(searchCode2 == ""){
			sql += " WHERE " + where +" LIKE '%" + searchCode1 +"%';";
		}else{
			sql += " WHERE band_name LIKE %" + searchCode1 +"%" +
			"AND music_name LIKE %" +searchCode2 +"%;";
		}

		Dao dao = null;
		ResultSet rs =null;
		try{
			System.out.println("うんち１");
			dao = new Dao();
			System.out.println("うんち２");

			rs = dao.execute(sql);

			while(rs.next()){
				tbl.add(rs.getString("music_name"));
				System.out.println(rs.getString("music_name"));
			}

		}catch(Exception e){
			System.out.println("unticham");
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				dao.close();
			}
			catch(Exception e){

			}

		}
		System.out.println(sql);
		return tbl;

	}

public ArrayList<String> ArtistSearch(String targetColumn,String where,String searchCode1,String searchCode2){
	ArrayList<String>tbl = new ArrayList<String>();
	String sql = "SELECT DISTINCT '" + targetColumn +"' FROM album" +
			"INNER JOIN music ON album.album_id = music.album_id" +
			"INNER JOIN contribution ON contribution.album_id = music.album_id && contribution.album_count = music.album_count" +
			"INNER JOIN band ON contribution.band_id = band.band_id";
	if(searchCode2 == null){
		sql += "WHERE '" + where +"' LIKE %'" + searchCode1 +"'%;";
	}else{
		sql += "WHERE band_name LIKE %'" + searchCode1 +"'%" +
		"AND music_name LIKE %'" +searchCode2 +"'%;";
	}
	Dao dao = null;
	ResultSet rs =null;
	try{
		dao = new Dao();
		rs = dao.execute(sql);



		while(rs.next()){
			tbl.add(rs.getString("'"+ targetColumn +"'"));
		}

	}catch(Exception e){
	}
	finally{
		try{
			if(rs != null){
				rs.close();
			}
			dao.close();
		}
		catch(Exception e){

		}

	}
	return tbl;

}

}