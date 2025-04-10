use movie;

select
	user.name as 고객,
    movie.director as 감독
from 
	user
join
	movie
on
	user.id = movie.user_id;