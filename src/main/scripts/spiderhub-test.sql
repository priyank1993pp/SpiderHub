-- NECESSARY TO TEST SPIDERHUB

INSERT INTO public.user_role(
	id, isdelete, userrole)
	VALUES (1000, 'no', 'ROLE-ADMIN');
INSERT INTO public.user_role(
	id, isdelete, userrole)
	VALUES (1001, 'no', 'ROLE-MANAGER');
INSERT INTO public.user_role(
	id, isdelete, userrole)
	VALUES (1002, 'no', 'ROLE-MEMBER');