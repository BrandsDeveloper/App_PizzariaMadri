package br.com.aulabancosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {

	
	private static final String NOME_BANCO = "aula_3col.db";
	private static final int VERSAO = 1;


	public CriaBanco(Context context) {
		super(context, NOME_BANCO, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE contatos ("
					+ "codigo integer primary key autoincrement," 
					+ "nome text,"
					+ "email text)";
		db.execSQL(sql);
		String sql1 = "CREATE TABLE usuarios ("
				+ "codigo integer primary key autoincrement,"
				+ "nome text,"
				+ "email text,"
				+ "senha text)";
		db.execSQL(sql1);

		String sql2 = "CREATE TABLE pedidos ("
				+ "codigo integer primary key autoincrement,"
				+ "nome text,"
				+ "qtdBolacha int,"
				+ "qtdLeite int, "
				+ "qtdCafe int, "
				+ "valorBolacha float, "
				+ "valorLeite float, "
				+ "valorCafe float, "
				+ "total float)";
		db.execSQL(sql2);

		String sql3 = "CREATE TABLE agendamento ("
				+ "codigo integer primary key autoincrement,"
				+ "nome text,"
				+ "data text,"
				+ "hora text) ";
		db.execSQL(sql3);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS contatos");
		db.execSQL("DROP TABLE IF EXISTS usuarios");
		db.execSQL("DROP TABLE IF EXISTS pedidos");
		db.execSQL("DROP TABLE IF EXISTS agendamento");
		onCreate(db);
	}
}
