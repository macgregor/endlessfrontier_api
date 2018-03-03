create table unit (
    id int not null,
    tribe int not null,
    class_name varchar not null,
    name varchar not null,
    cost int not null,
    shop_gem int not null,
    evolve_gem int not null,
    coin int not null,
    rare int not null,
    size int not null,
    evol_kind_num int not null,
    attack_type varchar not null,
    is_air_unit varchar not null,
    damage_type varchar not null,
    has_skill varchar not null,
    skill_attack_type varchar not null,
    skill_damage_type varchar not null,
    init_hp double not null,
    inc_hp double not null,
    init_damage double not null,
    inc_damage double not null,
    init_phy_def double not null,
    inc_phy_def double not null,
    init_mag_def double not null,
    inc_mag_def double not null,
    num_unit_block int not null,
    move_speed double not null,
    attack_speed int not null,
    skill_speed int not null,
    attack_range int not null,
    skill_range int not null,
    evade_percent double not null,
    block_percent double not null,
    critical_percent double not null,
    critical_damage double not null,
    splash_range int not null,
    splash_damage double not null,
    special_skill int not null,
    passive_skill int not null,
    revive_time int not null,
    bloody varchar not null,
    explode_die varchar not null,
    des varchar not null,
    message varchar not null,
    skill_list varchar not null,
    power_list varchar not null,
    rank int not null,
    sex varchar not null,
    ortho_grade varchar not null,
    shop int not null,
    show_book varchar not null,
    rating_position int not null,
    trans int not null,
    material1 varchar not null,
    material2 varchar not null,
    material3 varchar not null,
    star_buff int not null,
    jewel_buff int not null,
    ground_air varchar not null,
    offline_speed double not null,
    offline_time int not null,
    has_heart varchar not null,
    can_detect varchar not null,
    cloaking varchar not null,
    star_buff_from_pet int not null,
    is_honor int not null,
    honor_number int not null
);

create table tribe (
    id int not null,
    name varchar not null
);

insert into tribe (id, name) values (1, 'Human');
insert into tribe (id, name) values (2, 'Elf');
insert into tribe (id, name) values (3, 'Undead');
insert into tribe (id, name) values (4, 'Orc');
insert into tribe (id, name) values (5, 'Dungeon');

create table pet (
    id int not null,
    class_name varchar not null,
    name varchar not null,
    tribe int not null,
    type varchar not null,
    rank int not null,
    skill1 int not null,
    value1 varchar not null,
    skill2 int not null,
    value2 varchar not null,
    value3 varchar not null,
    master_skill int not null,
    couple int not null,
    inc_gold_level varchar not null,
    treasure int not null,
    is_percent varchar not null,
    is_alpha varchar not null
);

create table pet_skill (
    id int not null,
    named_id varchar not null,
    name varchar,
    sub varchar,
    type varchar,
    desc varchar,
    misc varchar
);

create table artifact (
    id int not null,
    name varchar not null,
    main_code varchar not null,
    sub_code int not null,
    grade int not null,
    max_lv int not null,
    desc varchar not null,
    open_cost varchar not null,
    skill_code1 varchar not null,
    ability1 int not null,
    ability11 int not null,
    ability21 int not null,
    skill_code2 varchar,
    ability2 int not null,
    ability12 int not null,
    ability22 int not null,
    skill_code3 varchar,
    ability3 int not null,
    upgrade_cost_type int not null,
    show_desc varchar not null,
    sort_id int not null
);

create table artifact_set(
    id int not null,
    title varchar not null,
    item_list varchar not null,
    num_set_list varchar not null,
    skill_list varchar not null,
    value_list varchar not null,
    value_list1 varchar not null,
    value_list2 varchar not null,
    desc varchar not null,
    history varchar,
    show_desc varchar not null
);

create table unit_skill(
    id int not null,
    skill_code varchar not null,
    img_index int not null,
    base_value int not null,
    desc varchar not null
);

create table translation(
    id varchar not null,
    value varchar
);