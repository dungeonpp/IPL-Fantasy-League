package com.dao.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import connection.Connection;
import dao.admin.AdminDao;

import com.model.Bidder;
import com.model.Match;
import com.model.Team;

public class AdminDaoImplementation implements AdminDao {

	static List<Bidder> bidder=new ArrayList<>();
	@Override
	public void addTeams() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMatches() {
		try{
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");		
			//ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			SessionFactory factory=cfg.buildSessionFactory();
			Session session=factory.openSession();
			Transaction t=session.beginTransaction();
			Team t1 =new Team();
			//			System.out.println("gandla transaaaaaaaaaaaaaaa");
			//            Class.forName("com.mysql.jdbc.Driver");
			//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ifleague","root","");
			//            con.setAutoCommit(false);
			//            PreparedStatement pstmt = null ;

			FileInputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\ipl_match.xls");
			POIFSFileSystem fs = new POIFSFileSystem( input );
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Row row;
			for(int i=1; i<=sheet.getLastRowNum(); i++){
				row = sheet.getRow(i);
				Date date = row.getCell(0).getDateCellValue();         
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String op4=sdf3.format(date);


				String teamA = row.getCell(1).getStringCellValue();

				String teamB = row.getCell(2).getStringCellValue();

				String matchwinner = row.getCell(3).getStringCellValue();

				int id1 = 0 ,id2 = 0 ;
				List<Team> list=new ArrayList<Team>();
				list=session.createQuery("from Team s").list();
				//System.out.println(list);
				Team team = null;
				Iterator itr=list.iterator();
				while(itr.hasNext()){
					team = (Team) itr.next();
					//itr.next();
					//String tn="Select teamName from Team";

					String tn=team.getTeamName();
					//System.out.println("bapppppppppppppppppooooooooooo");
					//System.out.println(tn);


					/*Query query = session.createQuery(tn);
                    int rowsAffected=query.executeUpdate();
                         System.out.println(rowsAffected);*/

					if(teamA.equalsIgnoreCase(tn))
					{ 
						
						//id1=team.getTeamId();
						//System.out.println("ho rahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						//System.out.println(id1);
						
					}

					if(teamB.equalsIgnoreCase(tn))
					{
						id2=team.getTeamId(); 
						//System.out.println("nahi ho rahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						//System.out.println(id2);
						
					}

				}
				Match match = new Match();
				match.
				/*String hql="from matches m where m.team1_id = :id1";
				List result = session.createQuery(hql)
						.setParameter("team1_id", id1)
						.list();
				String hq2="from matches m where m.team2_id = :id2";
				List result2 = session.createQuery(hq2)
						.setParameter("team2_id", id1)
						.list();
*/
				/*String hql="insert into matches(team1_id,team2_id)"+" values("+id1+","+id2+")";
				 int rowsAffected=session.createQuery(hql).executeUpdate();

	                if(rowsAffected>0){
	                	System.out.println(rowsAffected+"(s) were inserted");
	                }*/
				/*String query1="Select team_id from team where team_name="+teamA+"";
                int team1=Integer.parseInt(query1);

                String query2="Select team_id from team where team_name="+teamB+"";
                int team2=Integer.parseInt(query2);

               String hql="insert into matches(team1_id,team2_id,match_date_time,match_winner)"+" values("+id1+","+id2+",\'"+op4+"\',\'"+matchwinner+"\')";

        		String hql="insert into matches(:team1Id,:team2Id,:matchdatetime,:matchwinner)";
               Query query = session.createQuery(hql);
               query.setParameter("team1Id", id1);
               query.setParameter("team2Id", id2);
               query.setParameter("matchdatetime", op4);
               query.setParameter("matchwinner",matchwinner);
//                String hql="insert into matches(team1_id,team2_id,:match_date_time,:match_winner) "
//                		+ "Select team_id from team where team_name="+teamA+",Select team_id from team where team_name="+teamB+",op4,matchwinner";
//                
        		//System.out.println(hql);

               int rowsAffected=session.createQuery(hql).executeUpdate();
                //int rowsAffected=query.executeUpdate(); 
                if(rowsAffected>0){
                	System.out.println(rowsAffected+"(s) were inserted");
                }

				 */
				/*t.commit();
        		session.close();*/


			}
			t.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}


	}


	}

	@Override
	public List<Bidder> showPreviousWinner() {

		return bidder;
	}

	@Override
	public void declareMatchWinner(int Id,String winnerName) {
		Session session = Connection.getSession();
        Transaction t = session.beginTransaction();
        String query="update Match set matchWinner=\'"+winnerName+"\' where matchId=1";
        Query q=session.createQuery(query);
		q.executeUpdate();
//        Query  query=session.createQuery("from Match where match_id="+Id);
//        Iterator<Match> it=query.iterate();
//        while(it.hasNext())
//        {
//        	it.next().setMatchWinner(winnerName);
//        }
        t.commit();
        session.close();
        Connection.shutdown();
        
        
        
	}

	@Override
	public void updateMatches(int matchId,String dateTime) {
		Session session = Connection.getSession();
        Transaction t = session.beginTransaction();
		String query="update Match set match_date_time=\'"+dateTime+"\' where match_id="+matchId;
		Query q=session.createQuery(query);
		q.executeUpdate();
		t.commit();
		System.out.println(session.get(Match.class,1));
		session.close();
		Connection.shutdown();
	}

}
