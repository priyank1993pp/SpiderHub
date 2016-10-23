alter table CommentsOnTask 
        add constraint FKsh89tk9ftg72e5iruip968px0 
        foreign key (taskComments_id) 
        references Tasks

    alter table CommentsOnTask 
        add constraint FKbx9eokjw3omfmir3x15i9qj7o 
        foreign key (userComment_id) 
        references Users

    alter table Files 
        add constraint FKh860mvxnbvkl1ftxlwm8w5hjs 
        foreign key (taskFiles_id) 
        references Tasks

    alter table Projects 
        add constraint FKacvro7t5d14x2pes81u0xt1aw 
        foreign key (createdUser_id) 
        references Users

    alter table Projects 
        add constraint FK9l6ia1cwc1lnhtt69pjbo0re 
        foreign key (projectType_id) 
        references project_type

    alter table Projects_Users 
        add constraint FKu1wyudtkwbkr34d6ol5w8rc6 
        foreign key (usersRelatedProject_id) 
        references Users

    alter table Projects_Users 
        add constraint FK9f64q3piui34hsvvnjufxoct5 
        foreign key (projects_id) 
        references Projects

    alter table task_Activity 
        add constraint FKnxnc2fki7fb9wt35njsmm82cv 
        foreign key (activityOfTask_id) 
        references Tasks

    alter table task_Activity 
        add constraint FK4khdck689lusxovorst79b3uj 
        foreign key (activityOfTaskByUser_id) 
        references Users

    alter table Tasks 
        add constraint FK4hqx35ym9dcmkp3h6bptwggm2 
        foreign key (projectTasks_id) 
        references Projects

    alter table Tasks 
        add constraint FK3qg9dgph0ygbl9o2pxqig2qat 
        foreign key (statusTasks_id) 
        references statusOfTask

    alter table Tasks 
        add constraint FKsssbasun7c7xi0gjtiq9lvlls 
        foreign key (taskPriority_id) 
        references priorityOfTask

    alter table Tasks 
        add constraint FK9mwo5smpebqtx3nipvft15tey 
        foreign key (userTasks_id) 
        references Users

    alter table Users 
        add constraint FK31kvfhka4jccrverchdl1a823 
        foreign key (userRole_id) 
        references user_role