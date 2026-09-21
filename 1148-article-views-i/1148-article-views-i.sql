# Write your MySQL query statement below
select distinct a.author_id as id from Views a
where a.author_id = a.viewer_id
order by a.author_id;