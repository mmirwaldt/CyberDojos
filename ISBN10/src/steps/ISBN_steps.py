from behave import *

from ISBN import ISBN


@given(u'we have an ISBN validator')
def step_impl(context):
    context.validator = ISBN()


@when(u'we give it {isbn_str}')
def step_impl(context, isbn_str):
    context.actual = context.validator.validate(isbn_str)


@then(u'it is {expected:S}')
def step_impl(context, expected):
    assert context.actual == expected, f'actual {context.actual} is not expected {expected}'
